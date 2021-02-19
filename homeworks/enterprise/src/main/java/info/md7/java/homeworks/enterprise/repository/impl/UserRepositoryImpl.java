package info.md7.java.homeworks.enterprise.repository.impl;


import static info.md7.java.homeworks.enterprise.repository.columns.UserColumns.*;

import info.md7.java.homeworks.enterprise.domains.Gender;
import info.md7.java.homeworks.enterprise.domains.User;
import info.md7.java.homeworks.enterprise.repository.UserRepository;
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
public class UserRepositoryImpl implements UserRepository {

  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public List<User> findAll() {
    return jdbcTemplate.query("select * from m_users order by id", this::getRowMapper);
  }

  @Override
  public User save(User object) {
    final String saveQuery =
        "insert into m_users (username, surname, birth_date, login, password, is_blocked, weight, gender, country) "
            + "values (:username, :surname, :birth_date, :login, :password, :is_blocked, :weight, :gender, :country)";
    KeyHolder keyHolder = new GeneratedKeyHolder();
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("username", object.getName());
    params.addValue("surname", object.getSurname());
    params.addValue("birth_date", object.getBirthDate());
    params.addValue("login", object.getLogin());
    params.addValue("password", object.getPassword());
    params.addValue("is_blocked", object.getIsBlocked());
    params.addValue("weight", object.getWeight());
    params.addValue("gender", object.getGender().name());
    params.addValue("country", object.getCountry());
    namedParameterJdbcTemplate.update(saveQuery, params, keyHolder, new String[]{"id"});
    long createdUserId = Objects.requireNonNull(keyHolder.getKey()).longValue();

    return findById(createdUserId);
  }

  @Override
  public User findById(Long key) {
    return jdbcTemplate.queryForObject("select * from m_users where id = ?", new Object[]{key},
        this::getRowMapper);
  }

  @Override
  public Optional<User> findOne(Long key) {
    return Optional.of(findById(key));
  }

  @Override
  public User update(User object) {
    final String updateQuery = "update m_users "
        + "set username = ?, surname = ?, birth_date = ?, login = ?, password = ?, is_blocked = ?, "
        + "weight = ?, gender = ?, country = ? where id = ?";
    KeyHolder keyHolder = new GeneratedKeyHolder();
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("username", object.getName());
    params.addValue("surname", object.getSurname());
    params.addValue("birth_date", object.getBirthDate());
    params.addValue("login", object.getLogin());
    params.addValue("password", object.getPassword());
    params.addValue("is_blocked", object.getIsBlocked());
    params.addValue("weight", object.getWeight());
    params.addValue("gender", object.getGender().name());
    params.addValue("country", object.getCountry());
    params.addValue("id", object.getId());
    namedParameterJdbcTemplate.update(updateQuery, params, keyHolder, new String[]{"id"});
    long createdUserId = Objects.requireNonNull(keyHolder.getKey()).longValue();

    return findById(createdUserId);
  }

  @Override
  public boolean delete(User object) {
    return jdbcTemplate.update("delete from m_users where id = ?", object.getId()) == 1;
  }

  @Override
  public List<User> search(String query) {
    return jdbcTemplate.query("select * from m_users where username like ?", new Object[]{query},
        this::getRowMapper);
  }

  private User getRowMapper(ResultSet resultSet, int i) throws SQLException {
    User user = new User();
    user.setId(resultSet.getLong(ID));
    user.setName(resultSet.getString(NAME));
    user.setSurname(resultSet.getString(SURNAME));
    user.setBirthDate(resultSet.getDate(BIRTH_DATE));
    user.setLogin(resultSet.getString(LOGIN));
    user.setPassword(resultSet.getString(PASSWORD));
    user.setGender(Gender.valueOf(resultSet.getString(GENDER)));
    user.setCreated(resultSet.getTimestamp(CREATED));
    user.setChanged(resultSet.getTimestamp(CHANGED));
    user.setIsBlocked(resultSet.getBoolean(IS_BLOCKED));
    user.setWeight(resultSet.getFloat(WEIGHT));
    user.setCountry(resultSet.getString(COUNTRY));
    return user;
  }
}
