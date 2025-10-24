import java.util.List;
public interface ITicketRepository {
    List <Ticket> getTicketsBySector(SectorType sector);
    Ticket findTicket(SectorType sector, int seatNumber);
    List <Ticket> getAllTickets();
}
