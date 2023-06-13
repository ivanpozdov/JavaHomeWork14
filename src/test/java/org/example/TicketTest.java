package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    @Test
    public void testSortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("PNZ", "MSK", 200, 10, 12);
        Ticket ticket2 = new Ticket("PNZ", "MSK", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "SPB", 400, 10, 16);
        Ticket ticket4 = new Ticket("PNZ", "MSK", 800, 7, 7);
        Ticket ticket5 = new Ticket("KZN", "KLG", 200, 4, 9);
        Ticket ticket6 = new Ticket("PNZ", "MSK", 300, 6, 10);
        Ticket ticket7 = new Ticket("SPB", "MSK", 500, 15, 18);
        Ticket ticket8 = new Ticket("PNZ", "MSK", 600, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] expected = {ticket8, ticket4, ticket2, ticket6, ticket1};
        Ticket[] actual = manager.search("PNZ", "MSK");
    }

    @Test
    public void testSort1Ticket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("PNZ", "MSK", 200, 10, 12);
        Ticket ticket2 = new Ticket("PNZ", "MSK", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "SPB", 400, 10, 16);
        Ticket ticket4 = new Ticket("PNZ", "MSK", 800, 7, 7);
        Ticket ticket5 = new Ticket("KZN", "KLG", 200, 4, 9);
        Ticket ticket6 = new Ticket("PNZ", "MSK", 300, 6, 10);
        Ticket ticket7 = new Ticket("SPB", "MSK", 500, 15, 18);
        Ticket ticket8 = new Ticket("PNZ", "MSK", 600, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.search("KZN", "KLG");
    }

    @Test
    public void testSort0Ticket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("PNZ", "MSK", 200, 10, 12);
        Ticket ticket2 = new Ticket("PNZ", "MSK", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "SPB", 400, 10, 16);
        Ticket ticket4 = new Ticket("PNZ", "MSK", 800, 7, 7);
        Ticket ticket5 = new Ticket("KZN", "KLG", 200, 4, 9);
        Ticket ticket6 = new Ticket("PNZ", "MSK", 300, 6, 10);
        Ticket ticket7 = new Ticket("SPB", "MSK", 500, 15, 18);
        Ticket ticket8 = new Ticket("PNZ", "MSK", 600, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] expected = {};
        Ticket[] actual = manager.search("PBG", "DLC");
    }

    @Test
    public void TestSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("PNZ", "MSK", 200, 10, 12); //2
        Ticket ticket2 = new Ticket("PNZ", "MSK", 100, 11, 14); //3
        Ticket ticket3 = new Ticket("MSK", "SPB", 200, 10, 16);
        Ticket ticket4 = new Ticket("PNZ", "MSK", 400, 7, 17);   //10
        Ticket ticket5 = new Ticket("KZN", "KLG", 800, 4, 9);
        Ticket ticket6 = new Ticket("PNZ", "MSK", 200, 6, 10); //4
        Ticket ticket7 = new Ticket("SPB", "MSK", 300, 15, 18);
        Ticket ticket8 = new Ticket("PNZ", "MSK", 500, 7, 8); //1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket8, ticket1, ticket2, ticket6, ticket4};
        Ticket[] actual = manager.search("PNZ", "MSK", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSortTicketsWithComparator1() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("PNZ", "MSK", 200, 10, 12); //2
        Ticket ticket2 = new Ticket("PNZ", "MSK", 100, 11, 14); //3
        Ticket ticket3 = new Ticket("MSK", "SPB", 200, 10, 16);
        Ticket ticket4 = new Ticket("PNZ", "MSK", 400, 7, 17);   //10
        Ticket ticket5 = new Ticket("KZN", "KLG", 800, 4, 9);
        Ticket ticket6 = new Ticket("PNZ", "MSK", 200, 6, 10); //4
        Ticket ticket7 = new Ticket("SPB", "MSK", 300, 15, 18);
        Ticket ticket8 = new Ticket("PNZ", "MSK", 500, 7, 8); //1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket7};
        Ticket[] actual = manager.search("SPB", "MSK", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSortTicketsWithComparator2() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("PNZ", "MSK", 200, 10, 12); //2
        Ticket ticket2 = new Ticket("PNZ", "MSK", 100, 11, 14); //3
        Ticket ticket3 = new Ticket("MSK", "SPB", 200, 10, 16);
        Ticket ticket4 = new Ticket("PNZ", "MSK", 400, 7, 17);   //10
        Ticket ticket5 = new Ticket("KZN", "KLG", 800, 4, 9);
        Ticket ticket6 = new Ticket("PNZ", "MSK", 200, 6, 10); //4
        Ticket ticket7 = new Ticket("SPB", "MSK", 300, 15, 18);
        Ticket ticket8 = new Ticket("PNZ", "MSK", 500, 7, 8); //1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("KGD", "BDP", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}