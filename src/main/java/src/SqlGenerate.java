package src;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.commons.lang3.RandomUtils;
public class SqlGenerate
{
    public static void main( String[] args )
    {
        try{
            String data="";

            File file =new File("inserthireapp.txt");
            FileWriter fileWritter = new FileWriter(file.getName(),true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);

            BigInteger applicant_id = new BigInteger("310103199210112000");
            for(int i =0;i<10000;i++) {
                applicant_id = applicant_id.add(new BigInteger("1"));
                data = " \n"  +  applicant_id.toString() + ","+RandomUtils.nextInt(1, 100000)+ ","+1+","+0;
                bufferWritter.write(data);
            }


            //if file doesnt exists, then create it
            if(!file.exists()){
                file.createNewFile();
            }

            //true = append file
            bufferWritter.close();

            System.out.println("Done");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
