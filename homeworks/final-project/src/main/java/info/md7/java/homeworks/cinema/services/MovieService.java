package info.md7.java.homeworks.cinema.services;

import de.vandermeer.asciitable.AsciiTable;
import info.md7.java.homeworks.cinema.db.HibernateUtil;
import info.md7.java.homeworks.cinema.models.Movie;
import info.md7.java.homeworks.cinema.models.Ticket;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class MovieService {

  /**
   * Добавить новый фильм
   *
   * @param movieTitle название фильма
   * @param startDate дата и время начала
   */
  public static void addMovie(String movieTitle, LocalDateTime startDate) {
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
    Movie movie = new Movie();
    movie.setMovieTitle(movieTitle);
    movie.setStartDateTime(startDate);
    session.save(movie);
    session.getTransaction().commit();
  }

  /**
   * Метод возвращает общее кол-во фильмов
   *
   * @return Long
   */
  public static Long countMovies() {
    Session session = HibernateUtil.getSession();
    Query<Long> moviesCountQuery = session.createQuery("SELECT COUNT(*) FROM Movie movies");
    return moviesCountQuery.uniqueResult();
  }

  /**
   * Метод возвращает фильм по названию
   *
   * @param movieTitle название фильма
   * @return Movie
   */
  public static Movie getMovieByTitle(String movieTitle) {
    Session session = HibernateUtil.getSession();
    Query<Movie> getMovieQuery = session.createQuery("FROM Movie WHERE movieTitle=:movieTitle");
    getMovieQuery.setParameter("movieTitle", movieTitle);
    Movie movie = getMovieQuery.uniqueResult();
    session.close();
    return movie;
  }

  /**
   * Метод возвращает фильм по ID
   *
   * @param movieId идентификатор фильма
   * @return Movie
   */
  public static Movie getMovieById(Long movieId) {
    Session session = HibernateUtil.getSession();
    Query<Movie> getMovieQuery = session.createQuery("FROM Movie WHERE movieId=:movieId");
    getMovieQuery.setParameter("movieId", movieId);
    Movie movie = getMovieQuery.uniqueResult();
    session.close();
    return movie;
  }

  /**
   * Метод для редактирования выбранного фильма
   * @param movieId ID фильма
   * @param movieTitle Новое название фильма
   */
  public static void editMovie(Long movieId, String movieTitle) {
    Movie selectedMovie = getMovieById(movieId);
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
    selectedMovie.setMovieTitle(movieTitle);
    session.update(selectedMovie);
    session.getTransaction().commit();
    session.close();
  }

  /**
   * Распечатать информацию о фильмах
   */
  public static void printMovies() {
    Session session = HibernateUtil.getSession();
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Movie> criteria = builder.createQuery(Movie.class);
    criteria.from(Movie.class);
    List<Movie> movies = session.createQuery(criteria).getResultList();
    AsciiTable at = new AsciiTable();
    at.addRule();
    at.addRow("Id", "Название фильм", "Дата и время", "Кол-во доступных билетов");
    at.addRule();
    movies.forEach(movie -> {
      at.addRow(movie.getMovieId(), movie.getMovieTitle(), movie.getStartDateTime(), movie.getTickets().stream().filter(
          Ticket::getIsPurchased).count());
      at.addRule();
    });
    System.out.println(at.render());
    session.close();
    LoggerService.addMessage("Вы запросили список всех фильмов");
  }


  /**
   * Метод для удаления выбранного фильма по его Id
   * @param movieId Id фильма
   * @return boolean
   */
  public static void deleteMovieById(Long movieId) {
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
    Movie selectedMovie = (Movie) session.load(Movie.class, movieId);
    session.delete(selectedMovie);
    session.flush();
  }

  /**
   * Метод проверяет существует ли фильм по Id
   * @param movieId
   * @return
   */
  public static Boolean isMovieExists(Long movieId) {
    Session session = HibernateUtil.getSession();
    Query<Boolean> existsQuery = session.createQuery(
        "SELECT 1 FROM Movie WHERE EXISTS (SELECT 1 FROM Movie m WHERE movieId=:movieId)");
    existsQuery.setParameter("movieId", movieId);
    Boolean isMovieExists = existsQuery.uniqueResult() != null;
    session.close();
    return isMovieExists;
  }

}
