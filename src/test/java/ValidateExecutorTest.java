import com.chang.validateExecutor.ValidateException;
import com.chang.validateExecutor.ValidateExecutor;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class ValidateExecutorTest {

    @Test
    public void validateTest() {
        ValidateExecutor.of(new ValifierMock(5))
                .validate(v -> v.getInt() > 4)
                .validate(v -> v.getInt() > 3)
                .validate(v -> v.getInt() > 2)
                .execute(t -> Assert.assertThat(t.getInt(), is(5)));
    }

    @Test(expected = ValidateException.class)
    public void validateExceptionTest() {
        ValidateExecutor.of(new ValifierMock(5))
                .validate(v -> v.getInt() > 6)
                .execute(t -> {});
    }

    @Test(expected = ValidateException.class)
    public void validateExceptionTest2() {
        ValidateExecutor.of(new ValifierMock(5))
                .validate(v -> { throw new RuntimeException("exception"); })
                .execute(t -> {});
    }

    public static class ValifierMock {
        private Integer i;

        public ValifierMock(Integer i) {
            this.i = i;
        }

        public Integer getInt() {
            return i;
        }
    }
}
