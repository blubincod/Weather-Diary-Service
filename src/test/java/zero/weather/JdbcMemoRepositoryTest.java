package zero.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zero.weather.domain.Memo;
import zero.weather.repository.JdbcMemoRepository;

@SpringBootTest
@Transactional
public class JdbcMemoRepositoryTest {
    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {
        Memo newMemo = new Memo(1,"this is new memo:)");
        jdbcMemoRepository.save(newMemo);
    }


}
