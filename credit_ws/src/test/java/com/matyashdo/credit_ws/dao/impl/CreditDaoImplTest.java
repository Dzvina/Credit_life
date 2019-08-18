package com.matyashdo.credit_ws.dao.impl;

import com.matyashdo.credit_ws.model.Credit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CreditDaoImplTest {

    private static final int CREDIT_ID = 1;
    private static final int CUSTOMER_ID = 1;
    private static final int PRODUCT_ID = 1;
    private static final String NAME_CREDIT = "credit1";

    private Credit credit = new Credit();

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private CreditDaoImpl creditDaoImpl;

    @Captor
    ArgumentCaptor<Object[]> objectsArray;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        credit.setCreditId(CREDIT_ID);
        credit.setCustomerId(CUSTOMER_ID);
        credit.setProductId(PRODUCT_ID);
        credit.setNameCredit(NAME_CREDIT);
    }

    @Test
    public void testAddCredit() {
        String sql = "insert into credit (customer_id ,product_id ,name_credit) values (?,?,?)";

        creditDaoImpl.addCredit(credit);
        verify(jdbcTemplate).update(sql, credit.getCustomerId(), credit.getProductId(), credit.getNameCredit());
    }

    @Test
    public void testGetAllCredits() {
        List<Credit> credits = new ArrayList<>();

        when(jdbcTemplate.query(any(String.class), any(BeanPropertyRowMapper.class))).thenReturn(credits);

        List<Credit> actualCreditList = creditDaoImpl.getAllCredits();
        Assert.assertEquals(credits, actualCreditList);
    }

    @Test
    public void testGetCreditById() {
        when(jdbcTemplate.queryForObject(any(String.class), objectsArray.capture(), any(BeanPropertyRowMapper.class))).thenReturn(credit);

        Credit actualCredit = creditDaoImpl.getCreditById(CREDIT_ID);
        Assert.assertEquals(credit, actualCredit);
    }

    @Test
    public void testDeleteCreditById() {
        String sql = "delete from credit where credit_id = ?";

        creditDaoImpl.deleteCreditById(CREDIT_ID);
        verify(jdbcTemplate).update(sql, CREDIT_ID);
    }

    @Test
    public void testGetCreditsByCustomerId() {
        List<Credit> creditList = new ArrayList<>();
        creditList.add(credit);

        when(jdbcTemplate.query(anyString(), objectsArray.capture(), any(BeanPropertyRowMapper.class)))
                .thenReturn(creditList);

        List<Credit> actualCreditList = creditDaoImpl.getCreditsByCustomerId(CUSTOMER_ID);

        Assert.assertEquals(creditList, actualCreditList);
    }

    @Test
    public void testGetCreditsByProductId() {
        List<Credit> creditList = new ArrayList<>();
        creditList.add(credit);

        when(jdbcTemplate.query(anyString(), objectsArray.capture(), any(BeanPropertyRowMapper.class)))
                .thenReturn(creditList);

        List<Credit> actualCreditList = creditDaoImpl.getCreditsByProductId(PRODUCT_ID);

        Assert.assertEquals(creditList, actualCreditList);

    }
}