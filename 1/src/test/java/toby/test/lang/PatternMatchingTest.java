package toby.test.lang;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import toby.test.lang.dao.entity.immutable.Point;

class PatternMatchingTest {

	@Test
	void testInstanceOf() throws Exception {

		Object obj = "123";
		if (obj instanceof String s) {

			System.err.println(s);
		}
		assertTrue(true);
	}

	@Test
	void testSwitchWithWeekDay() throws Exception {

		var today = LocalDate.now().getDayOfWeek();
		var printString = switch (today) {
		case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "工作日";
		case SATURDAY, SUNDAY -> "快乐的周末";
		};
		assertNotNull(printString);
		System.err.println(printString);
	}

	@Test
	void testTextBlock() throws Exception {

		var sql = """
								SELECT
				  u.*
				FROM
				  USER u
				  INNER JOIN account a
				    ON a.xxf_id = u.xxf_id
				WHERE 1 = 1
				  AND a.phone_area_code IN
				  (SELECT
				    CODE
				  FROM
				    phone_area pa)
				  AND a.phone IN ("15922688569")
				  AND u.status IN (1)
				  AND a.status IN (1)
				  AND EXISTS
				  (SELECT
				    *
				  FROM
				    app_info ai
				  WHERE ai.business_code = u.business_code
				    AND ai.xxf_app_id = 1);
								""";
		assertNotNull(sql);
		System.err.printf(sql);
		System.err.println("""
				'啊哈',你港嘿咩嘿

				"阿拉同你港"
				""");
		System.err.println("""
				\"""
				\"""
				""");
	}

	@Test
	void testRecord() throws Exception {

		Point point = new Point(1, 1);
		System.err.println(point.x());
	}

	@Test
	void testPatternMatchingForInstanceof() throws Exception {

		Consumer<Object> consumer = obj -> {
			if (obj instanceof String s) {
				System.err.println(s);
			}
		};
		consumer.accept("pattern matching for instanceof is done");
	}

}
