package lession1.hw1;

public class Cross {

    public static void main(String[] args) {

        Athlete athlete1 = new Athlete("Jack", 3, 2, 0);
        Athlete athlete2 = new Athlete("Jane", 1, 0, 2);
        Athlete athlete3 = new Athlete("John", 0, 2, 3);
        Athlete athlete4 = new Athlete("Bill", 6, 4, 4);

        Team team = new Team("The Gods", new Athlete[]{athlete1, athlete2, athlete3, athlete4}); // Создаем команду

        Obstacle obstacle1 = new Obstacle("distance", 5);
        Obstacle obstacle2 = new Obstacle("crossbar", 2);
        Obstacle obstacle3 = new Obstacle("pool", 3);

        Course course = new Course("IronMan", new Obstacle[]{obstacle1,obstacle2,obstacle3}); // Создаем полосу препятствий5

        team.teammatesList(); // выводим список участников команды
        course.goCourse(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
    }
}
