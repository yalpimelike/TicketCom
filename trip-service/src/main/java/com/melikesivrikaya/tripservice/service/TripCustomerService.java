package com.melikesivrikaya.tripservice.service;

import com.melikesivrikaya.tripservice.client.ticket.TicketClientService;
import com.melikesivrikaya.tripservice.dto.TicketAddBasketRequest;
import com.melikesivrikaya.tripservice.model.Ticket;
import com.melikesivrikaya.tripservice.model.Trip;
import com.melikesivrikaya.tripservice.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TripCustomerService {

    private final TripRepository tripRepository;
    private final TicketClientService ticketClientService;
    private final List<Ticket> ticketList = new ArrayList<>();

    // BURASI KULLANICININ SEPETİNE BİLET EKLEME İŞLEMİNİ YAPIYOR
    public Ticket ticketAddBasket(TicketAddBasketRequest request) {
        Trip trip = tripRepository.findById(request.getTripId()).orElse(null);
        if (trip == null) {
            throw new RuntimeException("Sefer bulunamadı");
        }
        if (trip.getAvailableCount() < 1 ){
            throw new RuntimeException("Sefer için bilet kalmamıştır");
        }

        // Aynı sefer için kullanıcının aldığı bilet sayısı
        int ticketCountByUserId = ticketClientService.validateTicket(request.getUserId(),request.getTripId());

        if (ticketCountByUserId > 0) {
            // Kullanıcının bireyselmi kurumsalmı olduğunu tokendan al
            // ona göre kontrol gerçekleştir kurumsalsa daha önce aldıklarıyla yeni alacağı 40 geçemez
            //bireyselse 5 i geçemez
        }
        // bilet sepete ekleniyor
        Ticket ticket = new Ticket(request.getUserId(), request.getTripId(), request.getTravellerName(), request.getTravellerGender());
        ticketList.add(ticket);
        return ticket;
        // TODO ve birsürü logic işlem yap
    }
}
