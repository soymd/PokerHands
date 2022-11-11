import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class MainTest {
    @Before
    fun setUp() {
        println("setUp")
    }

    @Test
    fun test() {
        main()
        assertThat(1, equalTo(1))
    }

}