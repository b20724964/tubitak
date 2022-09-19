package yte.intern.proje.room.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.proje.common.entity.BaseEntity;
import yte.intern.proje.lecture.entity.Lecture;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "rooms")
@Getter
@NoArgsConstructor
public class Room extends BaseEntity {

    private RoomEnum name;
    private boolean hasProjection;
    private boolean hasComputer;
    private boolean hasCooler;
    private boolean hasWindow;
    private Long capacity;

    private String lesson1;
    private String lesson2;
    private String lesson3;
    private String lesson4;
    private String lesson5;
    private String lesson6;
    private String lesson7;
    private String lesson8;
    private String lesson9;
    private String lesson10;
    private String lesson11;
    private String lesson12;
    private String lesson13;
    private String lesson14;
    private String lesson15;
    private String lesson16;
    private String lesson17;
    private String lesson18;
    private String lesson19;
    private String lesson20;
    private String lesson21;
    private String lesson22;
    private String lesson23;
    private String lesson24;
    private String lesson25;
    private String lesson26;
    private String lesson27;
    private String lesson28;
    private String lesson29;
    private String lesson30;
    private String lesson31;
    private String lesson32;
    private String lesson33;
    private String lesson34;
    private String lesson35;
    private String lesson36;
    private String lesson37;
    private String lesson38;
    private String lesson39;
    private String lesson40;
    private String lesson41;
    private String lesson42;
    private String lesson43;
    private String lesson44;
    private String lesson45;
    private String lesson46;
    private String lesson47;
    private String lesson48;
    private String lesson49;
    private String lesson50;
    private String lesson51;
    private String lesson52;
    private String lesson53;
    private String lesson54;
    private String lesson55;
    private String lesson56;

    public Room(RoomEnum name, boolean hasProjection, boolean hasComputer, boolean hasCooler, boolean hasWindow, Long capacity) {
        this.name = name;
        this.hasProjection = hasProjection;
        this.hasComputer = hasComputer;
        this.hasCooler = hasCooler;
        this.hasWindow = hasWindow;
        this.capacity = capacity;

        this.lesson1="";
        this.lesson2="";
        this.lesson3="";
        this.lesson4="";
        this.lesson5="";
        this.lesson6="";
        this.lesson7="";
        this.lesson8="";
        this.lesson9="";
        this.lesson10="";
        this.lesson11="";
        this.lesson12="";
        this.lesson13="";
        this.lesson14="";
        this.lesson15="";
        this.lesson16="";
        this.lesson17="";
        this.lesson18="";
        this.lesson19="";
        this.lesson20="";
        this.lesson21="";
        this.lesson22="";
        this.lesson23="";
        this.lesson24="";
        this.lesson25="";
        this.lesson26="";
        this.lesson27="";
        this.lesson28="";
        this.lesson29="";
        this.lesson30="";
        this.lesson31="";
        this.lesson32="";
        this.lesson33="";
        this.lesson34="";
        this.lesson35="";
        this.lesson36="";
        this.lesson37="";
        this.lesson38="";
        this.lesson39="";
        this.lesson40="";
        this.lesson41="";
        this.lesson42="";
        this.lesson43="";
        this.lesson44="";
        this.lesson45="";
        this.lesson46="";
        this.lesson47="";
        this.lesson48="";
        this.lesson49="";
        this.lesson50="";
        this.lesson51="";
        this.lesson52="";
        this.lesson53="";
        this.lesson54="";
        this.lesson55="";
        this.lesson56="";
    }

    public void update(Room newRoom){
        this.capacity= newRoom.capacity;
        this.hasComputer = newRoom.hasComputer;
        this.hasCooler= newRoom.hasCooler;
        this.hasWindow= newRoom.hasWindow;
        this.hasProjection= newRoom.hasProjection;
    }

    public void updateTimeTable(List<String> timeTable){
        this.lesson1=timeTable.get(0);
        this.lesson2=timeTable.get(1);
        this.lesson3=timeTable.get(2);
        this.lesson4=timeTable.get(3);
        this.lesson5=timeTable.get(4);
        this.lesson6=timeTable.get(5);
        this.lesson7=timeTable.get(6);
        this.lesson8=timeTable.get(7);
        this.lesson9=timeTable.get(8);
        this.lesson10= timeTable.get(9);
        this.lesson11= timeTable.get(10);
        this.lesson12= timeTable.get(11);
        this.lesson13= timeTable.get(12);
        this.lesson14= timeTable.get(13);
        this.lesson15= timeTable.get(14);
        this.lesson16= timeTable.get(15);
        this.lesson17= timeTable.get(16);
        this.lesson18= timeTable.get(17);
        this.lesson19= timeTable.get(18);
        this.lesson20= timeTable.get(19);
        this.lesson21= timeTable.get(20);
        this.lesson22= timeTable.get(21);
        this.lesson23= timeTable.get(22);
        this.lesson24= timeTable.get(23);
        this.lesson25= timeTable.get(24);
        this.lesson26= timeTable.get(25);
        this.lesson27= timeTable.get(26);
        this.lesson28= timeTable.get(27);
        this.lesson29= timeTable.get(28);
        this.lesson30= timeTable.get(29);
        this.lesson31= timeTable.get(30);
        this.lesson32= timeTable.get(31);
        this.lesson33= timeTable.get(32);
        this.lesson34= timeTable.get(33);
        this.lesson35= timeTable.get(34);
        this.lesson36= timeTable.get(35);
        this.lesson37= timeTable.get(36);
        this.lesson38= timeTable.get(37);
        this.lesson39= timeTable.get(38);
        this.lesson40= timeTable.get(39);
        this.lesson41= timeTable.get(40);
        this.lesson42= timeTable.get(41);
        this.lesson43= timeTable.get(42);
        this.lesson44= timeTable.get(43);
        this.lesson45= timeTable.get(44);
        this.lesson46= timeTable.get(45);
        this.lesson47= timeTable.get(46);
        this.lesson48= timeTable.get(47);
        this.lesson49= timeTable.get(48);
        this.lesson50= timeTable.get(49);
        this.lesson51= timeTable.get(50);
        this.lesson52= timeTable.get(51);
        this.lesson53= timeTable.get(52);
        this.lesson54= timeTable.get(53);
        this.lesson55= timeTable.get(54);
        this.lesson56= timeTable.get(55);
    }

    public List<String> getTimetable(){
       List<String> timeTable = new ArrayList<>();
       timeTable.add(this.lesson1);

       return timeTable;

    }

    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER)
    private Set<Lecture> lectures = new HashSet<>();
}
