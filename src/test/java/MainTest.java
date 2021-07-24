import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    @Test
    public void test() {
        int profit = new Main().maxProfit(new int[] { 1 });
        assertThat(profit).isEqualTo(0);
    }
}