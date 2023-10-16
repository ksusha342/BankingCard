import org.example.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckNameTest {
    private final String name;
    private final boolean result;

    public CheckNameTest(String name, boolean result) {
        this.name = name;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getAccordionContent() {
        return new Object[][] {
                {"Petrov Ivan", true},
                {"petrov ivan", true},
                {"Петров Иван", true},
                {"Y", false},
                {"YR", false},
                {"Y R", true},
                {"Pervenko Alexander", true},
                {"Pervenkov Alexander", true},
                {"Perovenkov Alexander", false},
                {"Perovenko  Alexander", false},
                {" PetrovIvan", false},
                {" Petrov Ivan", false},
                {"PetrovIvan ", false},
                {"Petrov Ivan ", false},
                {"PetrovIvan", false},
                {"Petrov  Ivan", false},
                {"Pet rov Ivan", false},
        };
    }

    @Test
    public void checkName() {
        Account account = new Account(name);
        Assert.assertEquals(result, account.checkNameToEmboss());
    }

}
