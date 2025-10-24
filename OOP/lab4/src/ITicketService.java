public interface ITicketService {
    boolean buyTicket(SectorType sector, int seatNumber);
    void showAvailableTickets(SectorType sector);
}
