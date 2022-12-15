package ca.jrvs.apps.trading.dao;


import ca.jrvs.apps.trading.model.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class QuoteDao implements CrudRepository<Quote,String> {
    private static final String TABLE_NAME="quote";
    private static final String ID_COLUMN_NAME= "ticker";

    private static final Logger logger = LoggerFactory.getLogger(QuoteDao.class);
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;
    @Autowired
    public QuoteDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME);
    }

    /**
     * hint: http://bit.ly/2sDz8hq DataAccessException family
     * @throws DataAccessException for unexpected SQL results or SQL execution failure
     */
    @Override
    public Quote save(Quote quote){
        if (existsById(quote.getTicker())){
            int updatedRowNo = updateOne(quote);
            if (updatedRowNo!=1){
                throw new DataRetrievalFailureException("Unable to update quote");
            }

        }else{
            addOne(quote);
        }
        return quote;
    }

    /**
     * helper method that saves one quote
     *
     */
    private void addOne(Quote quote){
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(quote);
        int row = simpleJdbcInsert.execute(parameterSource);
        if (row!=1){
            throw new IncorrectResultSizeDataAccessException("Failed to insert",1,row);
        }
    }

    /**
     * helper method that updates one quote
     */
    private int updateOne(Quote quote){
        String update_sql = "UPDATE quote SET last_price=?, bid_price=?,"
                + "bid_size=?, ask_price=?, ask_size=? WHERE ticker=?";
        return jdbcTemplate.update(update_sql,makeUpdateValues(quote));
    }

    /**
     * helper method that makes sql update values objects
     * @param quote to be updated
     * @return UPDATE_SQL values
     */
    private Object[] makeUpdateValues(Quote quote){

    }

    @Override
    public <S extends Quote> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    /**
     * Find a quote by ticker
     * @param ticker name
     * @return qupte or Optional.empty if not found
     */

    @Override
    public Optional<Quote> findById(String ticker) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String ticker) {
        return false;
    }

    /**
     * return all quotes
     * @throws DataAccessException if failed to update
     */
    @Override
    public List<Quote> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(String ticker) {

    }
    @Override
    public Iterable<Quote> findAllById(Iterable<String> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void delete(Quote quote) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll(Iterable<? extends Quote> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }


}
