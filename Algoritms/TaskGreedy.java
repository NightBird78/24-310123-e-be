import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TaskGreedy {
    public static void main(String[] args) {
        Event event1 = new Event("Event 1", 10, 13);
        Event event2 = new Event("Event 2", 15, 17);
        Event event3 = new Event("Event 3", 13, 16);

        List<Event> rawEventList = Arrays.asList(event1, event2, event3);
        List<Event> eventList = new ArrayList<>();

        System.out.println("start Activity list:");
        System.out.println(rawEventList);
        System.out.println();

        rawEventList = rawEventList.stream().sorted(Comparator.comparing(Event::getCost).reversed()).toList();
        rawEventList.forEach(el -> Schedule.addBetter(eventList, el));


        List<Event> finalList = eventList.stream().sorted(Comparator.comparing(Event::getStartTime)).toList();

        int totalCost = finalList.stream()
                .map(Event::getCost)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Final total cost: " + totalCost);
        System.out.println();
        System.out.println("In schedule:");
        System.out.println(finalList);
    }
}


@Getter
@AllArgsConstructor
class Event {
    private String title;
    private Integer startTime;
    private Integer endTime;

    public int getCost() {
        int cost = 0;
        for (int i = startTime; i < endTime; i++) {

            if (i < 13) {
                cost++;
            } else {
                cost += 2;
            }
        }
        return cost;
    }

    public Event whatsBetter(Event event) {
        if (this.getCost() > event.getCost()) {
            return this;
        }
        return event;
    }

    @Override
    public String toString() {
        return "Event{" +
                "\ntitle: " + title +
                "\nstart: " + startTime +
                "\nend:   " + endTime + "\n}";
    }
}

class Schedule {
    public static boolean fitEvents(Event event1, Event event2) {
        if (
                (event1.getStartTime() >= event2.getStartTime() && event1.getStartTime() < event2.getEndTime()) ||
                (event1.getEndTime() > event2.getStartTime() && event1.getEndTime() <= event2.getEndTime())
        ) {
            return false;
        }
        return !(
                (event2.getStartTime() >= event1.getStartTime() && event2.getStartTime() < event1.getEndTime()) ||
                (event2.getEndTime() > event1.getStartTime() && event2.getEndTime() <= event1.getEndTime())
        );
    }

    public static void addBetter(List<Event> eventList, Event event) {

        for (Event ev : eventList) {
            if (!fitEvents(ev, event)) {
                Event better = ev.whatsBetter(event);
                if (better != ev) {
                    eventList.remove(ev);
                    eventList.add(event);
                }
                return;
            }
        }
        eventList.add(event);
    }
}
