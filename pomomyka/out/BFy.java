import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    static Random xi = new Random();
    static String hz;
    static int lm = 0;

    static ArrayList<String> ye = new ArrayList<>();

    static String oo = String.valueOf((char)xi.nextInt(65,91))+String.valueOf((char)xi.nextInt(65,91)) + String.valueOf((char)xi.nextInt(97,123));
    public static void main(String[] args) {
        System.out.println("Укажите абсолютный путь до файла");
        Scanner pe = new Scanner(System.in);
        String gf = pe.nextLine();
        String hq;
        int yi;
        StringBuilder oo = new StringBuilder();

        try(FileReader fs = new FileReader(gf)){
            while((yi = fs.read())!=-1){
                oo.append((char) yi);
            }
        }
        catch (IOException ex){
            ex.getMessage();
        }
        hq = oo.toString();

        hq = deleteLineComments(hq);

        hq = renameClass(hq, gf);
        hq = variableSwap(hq);
        hq = methodSwap(hq);
       

        hq = deleteSpaces(hq);
        hq = deleteMultiLineComments(hq);


        try(FileWriter cs = new FileWriter("X:/PRJjava/ProgExample/src/"+oo+".java")){
            cs.write(hq);
            cs.flush();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static String deleteLineComments(String hq){
        hq = hq.replaceAll("\s//(.+)","");
        return hq;
    }
    public static String deleteMultiLineComments(String hq){
        hq = hq.replaceAll("/\\*(.*)\\*/","");
        return hq;
    }
    public static String renameClass(String hq,String gf){
        Pattern ii = Pattern.compile("\\\\(\\w*)\\.java");
        Matcher bp = ii.matcher(gf);
        bp.find();
        hz = bp.group().replaceAll("\\\\|\\.java","");
        hq = hq.replaceAll(hz, oo);
        return hq;
    }
    public static String deleteSpaces(String hq){

        hq = hq.replaceAll("\r|\n","");
        hq = hq.replaceAll(";(\s*)",";");
        hq = hq.replaceAll("(\\{)(\s+)","{");
        hq = hq.replaceAll("(\\})(\s+)","}");
        hq = hq.replaceAll("\s+=|\s+=\s+|=\s+", "=");
        hq = hq.replaceAll(", | ,",",");
        return hq;
    }
    public static String variableCounter(String hq){
        Pattern ii = Pattern.compile("(.*)\s[a-z]([A-Za-z\\d]*)(;|((\s=\s)|=|\s=)(.*);)");
        Matcher bp = ii.matcher(hq);
        int lm = 0;

        while(bp.find()){
            lm++;
        }

        bp = ii.matcher(hq);
        String ny;
        String wo;
        ArrayList<String> ye = new ArrayList<>();
        ye.add(String.valueOf((char) xi.nextInt(97,122)));
        while (bp.find()){
            Pattern ax = Pattern.compile("\\s[a-z]([A-Za-z\\d]*)((\s=)|=|;)");
            Matcher uo = ax.matcher(bp.group());
            String jm;
            ny = String.valueOf((char)xi.nextInt(97,122));

            if(uo.find()){
                for(int yi = 0; yi<ye.size();yi++){
                    if(!(ye.get(yi).equals(ny))){
                        continue;
                    }
                    if(lm >26){
                        ny = String.valueOf((char)xi.nextInt(97,123)) + String.valueOf((char)xi.nextInt(97,123));
                        yi = 0;
                        ye.add(ny);
                    }
                    else {
                        ny = String.valueOf((char) xi.nextInt(97, 123));
                        yi = 0;
                        ye.add(ny);
                    }
                }
                wo = uo.group().replaceAll("=|\s|;","");

                Pattern ox = Pattern.compile("\\W"+wo+"\\W");
                Matcher ru = ox.matcher(hq);

                while(ru.find()){
                    jm = ru.group().replace(wo,ny);
                    hq = hq.replace(ru.group(),jm);
                }
            }
        }
        return hq;
    }
    public static String variableSwap(String hq){
        Pattern dj = Pattern.compile("(\\w|>)\s\\b[a-z]([A-z\\d]*)(;| =|=)");
        Matcher sa = dj.matcher(hq);
        Pattern ej = Pattern.compile("\s[a-z]([A-z\\d]*)\\b");
        Matcher aa;
        boolean su;
        ArrayList<String> jd = new ArrayList<>();
        while(sa.find()){
            su =false;

            lm++;
            aa = ej.matcher(sa.group());
            if (aa.find()) {
                for(int yi = 0; yi<jd.size();yi++){
                    if(aa.group().replaceAll("\s", "").equals(jd.get(yi))){
                        su = true;
                        break;
                    }
                }
                if(!su) {
                    jd.add(aa.group().replaceAll("\s", ""));
                }
            }
        }

        String ny = String.valueOf((char) xi.nextInt(97,122));
        ye.add(ny);
        for (String item:jd) {
            for(int yi = 0;yi<ye.size();yi++){
                if(ny.equals(ye.get(yi))){
                    if(lm>26){
                        ny = String.valueOf((char) xi.nextInt(97,122))+String.valueOf((char)xi.nextInt(97,123));
                    }
                    else{
                        ny = String.valueOf((char) xi.nextInt(97,122));
                    }
                    yi = 0;
                }
            }
            ye.add(ny);
            hq = hq.replaceAll("\\b"+item+"\\b",ny);
        }

        return hq;
    }
    public static String methodSwap(String hq){
        Pattern wm = Pattern.compile("\\w\s[a-z][A-z\\d]+\\((.+)\\)");
        Pattern vq = Pattern.compile("[a-z][A-z\\d]+");

        Matcher xx = wm.matcher(hq);
        Matcher bv;
        ArrayList<String> im = new ArrayList<>();
        while (xx.find()){
            bv = vq.matcher(xx.group());
            if(bv.find()&&!bv.group().equals("main")){
                im.add(bv.group());
            }
        }
        String ny = String.valueOf((char) xi.nextInt(97,122));
        ye.add(ny);
        for (String item:im) {
            for(int yi = 0;yi<ye.size();yi++){
                if(ny.equals(ye.get(yi))){
                    if(lm>26){
                        ny = String.valueOf((char) xi.nextInt(97,122))+String.valueOf((char)xi.nextInt(97,123));
                    }
                    else{
                        ny = String.valueOf((char) xi.nextInt(97,122));
                    }
                    yi = 0;
                }
            }
            ye.add(ny);
            hq = hq.replaceAll(item,ny);
        }

        return hq;
    }
}