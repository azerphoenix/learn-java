package info.md7.java.homeworks.cinema.services;

import de.vandermeer.asciitable.AsciiTable;
import info.md7.java.homeworks.cinema.db.HibernateUtil;
import info.md7.java.homeworks.cinema.models.Movie;
import info.md7.java.homeworks.cinema.models.Ticket;
import info.md7.java.homeworks.cinema.models.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class TicketService {

  /**
   * Метод возвращает общее кол-во билетов
   */
  public static Long countTickets() {
    Session session = HibernateUtil.getSession();
    Query<Long> ticketsCountQuery = session.createQuery("SELECT COUNT(*) FROM Ticket tickets");
    Long count = ticketsCountQuery.uniqueResult();
    session.close();
    return count;
  }

  /**
   * Метод возвращает билет по его id
   *
   * @param ticketId идентификатор билета
   * @return Ticket
   */
  public static Ticket getTicketById(Long ticketId) {
    Session session = HibernateUtil.getSession();
    Query<Ticket> getTicketQuery = session.createQuery("FROM Ticket WHERE ticketId=:ticketId");
    getTicketQuery.setParameter("ticketId", ticketId);
    Ticket ticket =  getTicketQuery.uniqueResult();
    session.close();
    return ticket;
  }

  /**
   * Метод добавляет новый билет
   *
   * @param seatNumber номер места
   * @param price стоимость
   * @param movieTitle название фильма
   */
  public static void addTicket(int seatNumber, double price, String movieTitle) {
    Movie movie = MovieService.getMovieByTitle(movieTitle);
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
    Ticket ticket = new Ticket();
    ticket.setSeatNumber(seatNumber);
    ticket.setPrice(price);
    ticket.setIsPurchased(false);
    ticket.setMovie(movie);
    session.save(ticket);
    session.getTransaction().commit();
    session.close();
  }

  /**
   * Распечатать информацию о доступных билетах
   *
   * @param movie фильм билеты, которого нужно распечатать
   */
  public static void printUnboughtTickets(Movie movie) {
    AsciiTable at = new AsciiTable();
    at.addRule();
    at.addRow("Id", "Номер билета", "Стоимость");
    at.addRule();
    Movie movieFromDb = MovieService.getMovieById(movie.getMovieId());
    movieFromDb.getTickets().stream().filter(ticket -> !ticket.getIsPurchased()).forEach(ticket -> {
      at.addRow(ticket.getTicketId(), ticket.getSeatNumber(), ticket.getPrice());
      at.addRule();
    });
    System.out.println(at.render());
  }

  /**
   * Метод реализует функционал покупки билета
   *
   * @param ticketId Идентификатор билета, который нужно приобрести
   * @param currentUser Пользователь, который желает приобрести билет
   * @return boolean
   */
  public static boolean buySelectedTicket(Long ticketId, User currentUser) {
    Ticket selectedTicket = getTicketById(ticketId);
    if (selectedTicket == null) {
      return false;
    }
    if (selectedTicket.getIsPurchased()) {
      return false;
    }
    boolean withdrawStatus = BalanceService.withdrawMoney(selectedTicket.getPrice(), currentUser);
    if (withdrawStatus) {
      Session session = HibernateUtil.getSession();
      session.beginTransaction();
      selectedTicket.setUser(currentUser);
      selectedTicket.setIsPurchased(true);
      session.update(selectedTicket);
      session.getTransaction().commit();
      session.close();
      return true;
    }
    return false;
  }

  /**
   * Метод для возврата (продажи) выбранного билета
   *
   * @param ticketId идентификатор возвращаемого билета
   * @param user текущий пользователь
   */
  public static void sellSelectedTicket(Long ticketId, User user) {
    Ticket selectedTicket = getTicketById(ticketId);
    BalanceService.refundMoney(selectedTicket.getPrice(), user);
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
    selectedTicket.setUser(null);
    selectedTicket.setIsPurchased(false);
    session.update(selectedTicket);
    session.getTransaction().commit();
    session.close();
  }

}
