import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccountRepositoryTest {

    private Connection conn;
    private AccountRepository repo;
    private PreparedStatement stmt;
    private ResultSet resultSet;

    @BeforeEach
    void setUp() throws Exception {
        conn = mock(Connection.class);
        stmt = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
        when(conn.prepareStatement(anyString())).thenReturn(stmt);
        repo = new AccountRepository(conn);
    }

    @Test
    void testUpdateBalance() throws Exception {
        repo.updateBalance(1, 500.0);
        verify(stmt).executeUpdate();
    }

    @Test
    void testGetAccount() throws Exception {
        when(stmt.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("accountNumber")).thenReturn(1);
        when(resultSet.getString("holderName")).thenReturn("John Doe");
        when(resultSet.getDouble("balance")).thenReturn(1000.0);
        when(resultSet.getString("status")).thenReturn("active");
        when(resultSet.getString("login")).thenReturn("user");
        when(resultSet.getInt("pin")).thenReturn(1234);

        Account account = repo.getAccountByLogin("user", 1234);

        assertNotNull(account);
        assertEquals(1, account.getAccountNumber());
        assertEquals("John Doe", account.getHolderName());
        assertEquals(1000.0, account.getBalance());
        assertEquals("active", account.getStatus());
        assertEquals("user", account.getLogin());
        assertEquals(1234, account.getPin());

        verify(stmt).executeQuery();
    }
}

