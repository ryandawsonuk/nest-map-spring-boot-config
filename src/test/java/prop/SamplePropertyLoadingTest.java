package prop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource("classpath:yamlpropstest.yml")
public class SamplePropertyLoadingTest {
    @Autowired
    private ActivitiProperty sampleProperty;


    @Test
    public void testLoadingOfProperties() {

        assertThat(sampleProperty.getCloud().getUser(), allOf(hasEntry("bob.policy.read", "TestProcess")));
        assertThat(sampleProperty.getCloud().getGroup(),
                hasEntry("hr.policy.read", "SimpleProcessYML1,SimpleProcessYML2"));
    }
}
