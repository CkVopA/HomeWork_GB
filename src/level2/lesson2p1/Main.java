/*
Java. Уровень 2
Урок 1. Объектно-ориентированное программирование Java
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).

2. Создайте два класса: беговая дорожка и стена, при прохождении через которые,
участники должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
 печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
 У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.

3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников
пройти этот набор препятствий. Если участник не смог пройти одно из препятствий,
то дальше по списку он препятствий не идет.
 */

package level2.lesson2p1;

public class Main {
    public static void main(String[] args) {
        Participants[] participants = {
                new Human(56,3),
                new Cat(20,4),
                new Robot(15, 2),
                new Human(90, 1),
                new Robot(33, 2),
                new Human(302, 5),
                new Cat(13,5)
        };

        Obstacles[] obstacles = {
                new Racetrack(17),
                new Wall(2),
                new Racetrack(41),
                new Wall(3),
                new Racetrack(50),
                new Wall(4)
        };

        startOfCompetition(participants, obstacles);
        announcementOfTheWinner(participants);
    }

    public static void startOfCompetition(Participants[] participants, Obstacles[] obstacles) {
        for (Participants participant : participants) {
            participant.overcomingOfObstacle(obstacles);
        }
    }

    public static void announcementOfTheWinner(Participants[] participants) {
        System.out.println();
        for (Participants participant : participants) {
            if (participant.isPossibleToContinueCompetition()) {
                System.out.println("WE HAVE A WINNER! " + participant);
            }
        }
    }
}
