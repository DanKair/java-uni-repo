import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TicketRepositoryImpl implements ITicketRepository{
    // Storage for "Ticket" class objects
    private List <Ticket> tickets = new ArrayList<>();

    @Override
    public List <Ticket> getTicketsBySector(SectorType sector){
        for (Ticket ticket: tickets){
            if (sector == ticket.sector){
                return this.tickets;
            }
            else{
                throw new IllegalArgumentException("Sectors doesn't match!");
        }
        }
        throw new NoSuchElementException("Tickets with following sector doesn't exist.");
    }
    

    @Override
    public List <Ticket> getAllTickets(){
        return this.tickets;
    }

    @Override
    public Ticket findTicket(SectorType sector, int seatNumber) {
        // TODO Auto-generated method stub
        for (Ticket ticket: tickets){
            if (sector == ticket.sector && seatNumber == ticket.seatNumber){
                return ticket;
            }
            else{
                throw new IllegalArgumentException("Sectors doesn't match!");
            }
        }   
        throw new UnsupportedOperationException("Method doesn't work correctly still yet.'");
    }
}
