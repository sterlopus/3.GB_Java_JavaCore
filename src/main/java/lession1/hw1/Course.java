package lession1.hw1;

public class Course {

    String name;
    Obstacle[] course;

    public Course(String name, Obstacle[] obstacle) {
        this.name = name;
        this.course = obstacle;
    }

    public String getName() {
        return name;
    }

    public Obstacle[] getCourse() {
        return course;
    }

    void goCourse(Team team){           // all teammates tries all obstacles
        for (Athlete mate:team.getTeam()) {
                for (Obstacle obs : course){
                    if (mate.getLength() < obs.size) {
                        mate.setFinish(false);
                        break;          // stop if mate failed any obstacle
                    }
                }
        }
    }
}


/**
 * 3. Добавить класс Course (полоса препятствий), в котором будут находиться:
 *     массив препятствий;
 *     метод, который будет просить команду пройти всю полосу.
 */