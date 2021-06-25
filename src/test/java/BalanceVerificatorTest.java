import org.junit.Assert;

class BalanceVerificatorTest {

    @org.junit.jupiter.api.Test
    void verificator() {

        Assert.assertEquals(new BalanceVerificator().verificator("{[]}"), -1);
        Assert.assertEquals(new BalanceVerificator().verificator("({[]}("), 6);
        Assert.assertEquals(new BalanceVerificator().verificator("{[(]}"), 3);
        Assert.assertEquals(new BalanceVerificator().verificator("{})"), 3);
        Assert.assertEquals(new BalanceVerificator().verificator("{}("), 3);
        Assert.assertEquals(new BalanceVerificator().verificator("{{[[(())]]}}"), -1);
        Assert.assertEquals(new BalanceVerificator().verificator("s[]"), 0);
        Assert.assertEquals(new BalanceVerificator().verificator("(){}"), -1);
        Assert.assertEquals(new BalanceVerificator().verificator("((())"), 1);
        Assert.assertEquals(new BalanceVerificator().verificator("({[(]})"), 4);
        Assert.assertEquals(new BalanceVerificator().verificator("]((())"), 1);
        Assert.assertEquals(new BalanceVerificator().verificator(""), 0);

    }
}


