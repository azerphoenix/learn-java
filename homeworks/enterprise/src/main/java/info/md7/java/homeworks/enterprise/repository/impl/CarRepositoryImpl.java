package info.md7.java.homeworks.enterprise.repository.impl;


import static info.md7.java.homeworks.enterprise.repository.columns.CarColumns.*;

import info.md7.java.homeworks.enterprise.domains.Car;
import info.md7.java.homeworks.enterprise.repository.CarRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Log4j
@Repository
@RequiredArgsConstructor
public class CarRepositoryImpl implements CarRepository {

  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public Car save(Car object) {
    final String insertCarQuery = "insert into m_cars (model, guarantee_expiration_date, price,"
        + "user_id, dealer_id, year, country) values (:model, :guarantee_expiration_date, :price, :user_id, :dealer_id, :year, :country)";
    KeyHolder keyHolder = new GeneratedKeyHolder();
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("model", object.getModel());
    params.addValue("guarantee_expiration_date", object.getGuaranteeExpirationDate());
    params.addValue("price", object.getPrice());
    params.addValue("user_id", object.getUserId());
    params.addValue("dealer_id", object.getDealerId());
    params.addValue("year", object.getYear());
    params.addValue("country", object.getCountry());
    namedParameterJdbcTemplate.update(insertCarQuery, params, keyHolder, new String[]{"id"});
    long createdUserId = Objects.requireNonNull(keyHolder.getKey()).longValue();

    return findById(createdUserId);
  }

  @Override
  public List<Car> findAll() {
    return jdbcTemplate.query("select * from m_cars order by id", this::getRowMapper);
  }

  @Override
  public Car findById(Long key) {
    return jdbcTemplate
        .queryForObject("select * from m_cars where id = ?", new Object[]{key}, this::getRowMapper);
  }

  @Override
  public Optional<Car> findOne(Long key) {
    return Optional.of(findById(key));
  }

  @Override
  public Car update(Car object) {
    final String updateCarQuery = "update m_cars set "
        + "model = :model, guarantee_expiration_date = :guarantee_expiration_date, price = :price, dealer_id = :dealer_id, user_id = :user_id, year = :year, country = :country "
        + "where id = :id";

    KeyHolder keyHolder = new GeneratedKeyHolder();
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("model", object.getModel());
    params.addValue("guarantee_expiration_date", object.getGuaranteeExpirationDate());
    params.addValue("price", object.getPrice());
    params.addValue("dealer_id", object.getDealerId());
    params.addValue("user_id", object.getUserId());
    params.addValue("year", object.getYear());
    params.addValue("country", object.getCountry());
    params.addValue("id", object.getId());
    namedParameterJdbcTemplate.update(updateCarQuery, params, keyHolder, new String[]{"id"});
    long createdUserId = Objects.requireNonNull(keyHolder.getKey()).longValue();

    return findById(createdUserId);
  }

  @Override
  public boolean delete(Car object) {
    return jdbcTemplate.update("delete from m_cars where id = ?", object.getId()) == 1;
  }

  @Override
  public List<Car> search(String query) {
    return jdbcTemplate
        .query("select * from m_cars where model like ?", new Object[]{query}, this::getRowMapper);
  }

  private Car getRowMapper(ResultSet rs, int i) throws SQLException {
    Car car = new Car();
    car.setId(rs.getLong(ID));
    car.setModel(rs.getString(MODEL));
    car.setGuaranteeExpirationDate(rs.getTimestamp(GUARANTEE_EXPIRATION_DATE));
    car.setPrice(rs.getDouble(PRICE));
    car.setYear(rs.getInt(YEAR));
    car.setCountry(rs.getString(COUNTRY));
    car.setDealerId(rs.getLong(DEALER_ID));
    car.setUserId(rs.getLong(USER_ID));
    return car;
  }

}
