package lession1.hw1;

public class Team {

    String teamName;
    Athlete[] team;

    // массив из четырех участников — в конструкторе можно сразу всех участников указывать
    public Team(String teamName, Athlete[] teamMates) {
        this.teamName = teamName;
        this.team = teamMates;
    }

    public String getTeamName() {
        return teamName;
    }

    public Athlete[] getTeam() {
        return team;
    }

    // метод вывода информации обо всех членах команды
    public void teammatesList() {
        System.out.println("Team \"" + teamName + "\" is: ");
        for (Athlete mate : team){
           System.out.println("     " + mate.getName() + ": can run " + mate.getLength() + "km, "
                   + "jump " + mate.getHigh() + "m, " + "swim " + mate.getDepth() + "m.");
       }
    }

    // метод для вывода информации о членах команды, прошедших дистанцию
    public void showResults(){
        System.out.println("\nOnly this athlete(es) of team \"" + teamName + "\" finished course:");
        for (Athlete mate : team){
            if (mate.isFinish()){
                System.out.println(mate.getName());
            }
        }
    }
}


/**
 * 2. Добавить класс Team, который будет содержать:
 *     название команды;
 *     массив из четырех участников — в конструкторе можно сразу всех участников указывать);
 *     метод для вывода информации о членах команды, прошедших дистанцию;
 *     метод вывода информации обо всех членах команды.
 */