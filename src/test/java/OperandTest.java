
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@RunWith(DataProviderRunner.class)
public class OperandTest {

    @DataProvider
    public static Iterable<OperandData> readFile() throws IOException {

        List<OperandData> operations = new ArrayList<OperandData>();
        FileInputStream fstream = new FileInputStream("src/test/resources/local.txt");
        BufferedReader read = new BufferedReader(new InputStreamReader(fstream));
        String strLine = read.readLine();
        while (strLine != null) {
            String[] split = strLine.split(";");
            operations.add(new OperandData().withOperand1(Integer.parseInt(split[0]))
                    .withOperand2(Integer.parseInt(split[1])).withOperation(split[2].charAt(0)).withResult(Integer.parseInt(split[3])));
            strLine = read.readLine();
        }

        return operations;
    }

    @Test
    @UseDataProvider("readFile")
    public void operandTest(OperandData operandData) {
        System.out.print(operandData.getOperand1() + "  ");
        System.out.print(operandData.getOperation() + "  ");
        System.out.print(operandData.getOperand2() + " = ");
        System.out.println(operandData.getResult() + "  ");
        Assert.assertEquals(operandData.evaluate(), operandData.getResult());
    }

}

