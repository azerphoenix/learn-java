package info.md7.java.homeworks.enterprise.repository.impl;


import static info.md7.java.homeworks.enterprise.repository.columns.DealerColumns.*;

import info.md7.java.homeworks.enterprise.domains.Dealer;
import info.md7.java.homeworks.enterprise.repository.DealerRepository;
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
public class DealerRepositoryImpl implements DealerRepository {

  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public Dealer save(Dealer object) {
    final String insertQuery = "insert into m_auto_dealer (name, address, capacity, created, "
        + "changed, year_of_foundation, country) "
        + "VALUES (:name, :address, :capacity, :created, :changed, :year_of_foundation, :country)";

    KeyHolder keyHolder = new GeneratedKeyHolder();
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("name", object.getName());
    params.addValue("address", object.getAddress());
    params.addValue("capacity", object.getCapacity());
    params.addValue("created", object.getCreated());
    params.addValue("changed", object.getChanged());
    params.addValue("year_of_foundation", object.getYearOfFoundation());
    params.addValue("country", object.getCountry());
    namedParameterJdbcTemplate.update(insertQuery, params, keyHolder, new String[]{"id"});
    long createdUserId = Objects.requireNonNull(keyHolder.getKey()).longValue();

    return findById(createdUserId);
  }

  @Override
  public List<Dealer> findAll() {
    return jdbcTemplate.query("select * from m_auto_dealer order by id", this::getRowMapper);
  }

  @Override
  public Dealer findById(Long key) {
    return jdbcTemplate
        .queryForObject("select * from m_auto_dealer where id = ?", new Object[]{key},
            this::getRowMapper);
  }

  @Override
  public Optional<Dealer> findOne(Long key) {
    return Optional.of(findById(key));
  }

  @Override
  public Dealer update(Dealer object) {
    final String updateQuery = "update m_auto_dealer "
        + "set name = :name, address = :address, capacity = :capacity, created = :created, changed = :changed, "
        + "year_of_foundation = :year_of_foundation, country = :country where id = :id";
    KeyHolder keyHolder = new GeneratedKeyHolder();
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("name", object.getName());
    params.addValue("address", object.getAddress());
    params.addValue("capacity", object.getCapacity());
    params.addValue("created", object.getCreated());
    params.addValue("changed", object.getChanged());
    params.addValue("year_of_foundation", object.getYearOfFoundation());
    params.addValue("country", object.getCountry());
    params.addValue("id", object.getId());
    namedParameterJdbcTemplate.update(updateQuery, params, keyHolder, new String[]{"id"});
    long createdUserId = Objects.requireNonNull(keyHolder.getKey()).longValue();

    return findById(createdUserId);
  }

  @Override
  public boolean delete(Dealer object) {
    return jdbcTemplate.update("delete from m_auto_dealer where id = ?", object.getId()) == 1;
  }

  @Override
  public List<Dealer> search(String query) {
    return jdbcTemplate.query("select * from m_auto_dealer where name like ?", new Object[]{query},
        this::getRowMapper);
  }

  private Dealer getRowMapper(ResultSet resultSet, int i) throws SQLException {
    Dealer dealer = new Dealer();
    dealer.setId(resultSet.getLong(ID));
    dealer.setName(resultSet.getString(NAME));
    dealer.setAddress(resultSet.getString(ADDRESS));
    dealer.setCapacity(resultSet.getInt(CAPACITY));
    dealer.setCreated(resultSet.getTimestamp(CREATED));
    dealer.setChanged(resultSet.getTimestamp(CHANGED));
    dealer.setYearOfFoundation(resultSet.getDate(YEAR_OF_FOUNDATION));
    dealer.setCountry(resultSet.getString(COUNTRY));
    return dealer;
  }
}
