package nextstep.repository.theme;

import nextstep.domain.theme.Theme;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DisplayName("Theme Repository 테스트 (콘솔)")
@Sql(scripts = {"classpath:recreate.sql"})
public class ConsoleThemeRepositoryTest {

    private final ThemeRepository consoleThemeRepository = new ConsoleThemeRepository();
    private static final Theme newTheme = new Theme(
            null,
            "작은 악마들",
            "잠실 인근에서 발생한 사건 수사",
            30000
    );

    @DisplayName("예외 없이 정상적으로 테마 생성 및 추가")
    @Test
    void addTheme() {
        assertThatNoException().isThrownBy(() -> consoleThemeRepository.add(newTheme));
    }

    @DisplayName("3개의 테마 추가 후 전체 조회시 개수 일치 확인")
    @Test
    void findAllTheme() {
        // given
        consoleThemeRepository.add(newTheme);
        consoleThemeRepository.add(newTheme);
        consoleThemeRepository.add(newTheme);

        // when
        List<Theme> themeList = consoleThemeRepository.findAll();

        // then
        assertThat(themeList.size()).isEqualTo(3);
    }
}