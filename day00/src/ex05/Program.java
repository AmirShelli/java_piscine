package ex05;

import java.sql.Struct;
import java.util.*;

public class Program {

    public static void main(String[] args) {
        ArrayList<Lesson> lessons = new ArrayList<>();
        HashMap<String, Pupil> pupils = new HashMap<>();

        Scanner sin = new Scanner(System.in);
        String input;
        String aux;

        while(true)
        {
            input = sin.nextLine();
            if(input.equals("."))
                break;
            pupils.put(input, new Pupil(input));
        }


        while(true)
        {
            input = sin.next();
            if(input.equals("."))
                break;
            aux = sin.next();
            Integer i = 0;
            while (i < 30)
            {
                for (days day : days.values())
                {
                    if(day == days.valueOf(aux) && i > 0)
                        lessons.add(new Lesson(input,days.valueOf(aux), i.toString()));
                    i++;
                }
            }
        }

        while(true)
        {
            input = sin.nextLine();
            if(input.equals("."))
                break;
            String[] s = input.split(" ");
            pupils.get(s[0]).setStatus(s[1], s[2],s[3]);
        }

        System.out.print("          |");
        for (Lesson lesson : lessons){
            System.out.printf("%s:00 %s %3s|", lesson.getTime(), lesson.getDay(), lesson.getDate());
        }

        for(Pupil pupil : pupils.values()){
            System.out.printf("%10s", pupil.getName());
            for (Lesson lesson : lessons){
                String status = pupil.getStatus(lesson.getDate());
                if(status != null)
                    System.out.printf("%10s|", status);
                else
                    System.out.print("          |");
            }
        }

    }

    enum days{
        MO, TU, WE, TH, FR, SA, SU
    }

    private static class Pupil{
        private String name;
        private HashMap<Lesson, String> status = new HashMap<>();

        Pupil(String name){
            this.name = name;
        }
        public void setStatus(String time, String date, String status){
            this.status.put(new Lesson(time, date), status);
        }
        public String getName(){ return name;}

        public String getStatus(String date){
            for(Map.Entry<Lesson,String> s : status.entrySet()){
                if(s.getKey().getDate().equals(date))
                    return s.getValue();
            }
            return null;
        }
    }

    private static class Lesson{
        private String time;
        private String date;
        private days day;
        
        Lesson(String time, String date)
        {
            this.time = time;
            this.date = date;
        }

        Lesson(String time, days day, String date)
        {
            this.time = time;
            this.date = date;
            this.day = day;
        }

        public String getTime() { return this.time;}
        public String getDate() { return this.date;}
        public days getDay(){ return this.day;}
    }
}
