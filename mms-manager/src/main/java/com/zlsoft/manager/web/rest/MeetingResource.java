package com.zlsoft.manager.web.rest;

import com.zlsoft.common.service.*;
import com.zlsoft.domain.*;
import com.zlsoft.manager.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/admin/meeting")
public class MeetingResource {

    @Inject
    private MeetingService meetingService;

    @Inject
    private MeetingSettingService meetingSettingService;

    @Inject
    private MeetingAffairService meetingAffairService;

    @Inject
    private MeetingDuesService meetingDuesService;

    @Inject
    private MeetingHotelService meetingHotelService;

    @Inject
    private MeetingPlaceService meetingPlaceService;

    @Inject
    private MeetingVisitorRouteService meetingVisitorRouteService;

    /**
     * GET  /page/{page} : get data of meetings by page
     * @param page zero-based page index
     * @return data of meetings by page
     */
    @GetMapping("/page/{page}")
    public ResponseEntity getMeetings(@PathVariable("page") int page){
        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<Meeting> meetings = this.meetingService.findAll(pageRequest);
        return ResponseEntity.ok(meetings);
    }

    /**
     * POST  /save : save meeting data
     * @param meeting meeting data to be saved
     * @return saved meeting data
     */
    @PostMapping("/save")
    public ResponseEntity save(Meeting meeting) {
        Meeting savedMeeting = this.meetingService.save(meeting);
        return ResponseEntity.ok(savedMeeting);
    }

    /**
     * POST  /delete : delete meeting data
     * @param id meeting id
     * @return HTTP status to figure if operation is successful
     */
    @PostMapping("/delete")
    public ResponseEntity delete(long id) {
        this.meetingService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * POST  /setting/save : save meeting setting data
     * @param setting meeting setting data to be saved
     * @return saved meeting setting data
     */
    @PostMapping("/setting/save")
    public ResponseEntity save(MeetingSetting setting) {
        setting = this.meetingSettingService.save(setting);
        return ResponseEntity.ok(setting);
    }

    /**
     * POST  /setting/delete : delete meeting setting data
     * @param id meeting id
     * @return HTTP status to figure if operation is successful
     */
    @PostMapping("/setting/delete")
    public ResponseEntity deleteSetting(long id) {
        this.meetingSettingService.deleteByMeetingId(id);
        return ResponseEntity.ok().build();
    }

    /**
     * POST  /affair/save : save meeting affair data
     * @param affair meeting affair data to be saved
     * @return saved meeting affair data
     */
    @PostMapping("/affair/save")
    public ResponseEntity save(MeetingAffair affair) {
        affair = this.meetingAffairService.save(affair);
        return ResponseEntity.ok(affair);
    }

    /**
     * POST  /affair/delete : delete meeting affair data
     * @param id meeting id
     * @return HTTP status to figure if operation is successful
     */
    @PostMapping("/affair/delete")
    public ResponseEntity deleteAffair(long id) {
        this.meetingAffairService.deleteByMeetingId(id);
        return ResponseEntity.ok().build();
    }

    /**
     * POST  /dues/save : save meeting dues data
     * @param dues meeting dues data to be saved
     * @return saved meeting dues data
     */
    @PostMapping("/dues/save")
    public ResponseEntity save(MeetingDues dues) {
        dues = this.meetingDuesService.save(dues);
        return ResponseEntity.ok(dues);
    }

    /**
     * POST  /dues/delete : delete meeting dues data
     * @param id meeting id
     * @return HTTP status to figure if operation is successful
     */
    @PostMapping("/dues/delete")
    public ResponseEntity deleteDues(long id) {
        this.meetingDuesService.deleteByMeetingId(id);
        return ResponseEntity.ok().build();
    }

    /**
     * POST  /dues/delete/{id} : delete meeting dues data by id
     * @param id dues id
     * @return HTTP status to figure if operation is successful
     */
    @PostMapping("/dues/delete/{id}")
    public ResponseEntity deleteDuesById(@PathVariable long id) {
        this.meetingDuesService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * POST  /hotel/save : save meeting hotel data
     * @param hotel meeting hotel data to be saved
     * @return saved meeting hotel data
     */
    @PostMapping("/hotel/save")
    public ResponseEntity save(MeetingHotel hotel) {
        hotel = this.meetingHotelService.save(hotel);
        return ResponseEntity.ok(hotel);
    }

    /**
     * POST  /hotel/delete : delete meeting hotel data
     * @param id meeting id
     * @return HTTP status to figure if operation is successful
     */
    @PostMapping("/hotel/delete")
    public ResponseEntity deleteHotel(long id) {
        this.meetingHotelService.deleteByMeetingId(id);
        return ResponseEntity.ok().build();
    }

    /**
     * POST  /hotel/delete/{id} : delete meeting hotel data by id
     * @param id hotel id
     * @return HTTP status to figure if operation is successful
     */
    @PostMapping("/hotel/delete/{id}")
    public ResponseEntity deleteHotelById(@PathVariable long id) {
        this.meetingHotelService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * POST  /place/save : save meeting place data
     * @param place meeting place data to be saved
     * @return saved meeting place data
     */
    @PostMapping("/place/save")
    public ResponseEntity save(MeetingPlace place) {
        place = this.meetingPlaceService.save(place);
        return ResponseEntity.ok(place);
    }

    /**
     * POST  /place/delete : delete meeting place data
     * @param id meeting id
     * @return HTTP status to figure if operation is successful
     */
    @PostMapping("/place/delete")
    public ResponseEntity deletePlace(long id) {
        this.meetingPlaceService.deleteByMeetingId(id);
        return ResponseEntity.ok().build();
    }

    /**
     * POST  /place/delete/{id} : delete meeting place data by id
     * @param id place id
     * @return HTTP status to figure if operation is successful
     */
    @PostMapping("/place/delete/{id}")
    public ResponseEntity deletePlaceById(@PathVariable long id) {
        this.meetingPlaceService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * POST  /route/save : save meeting route data
     * @param route meeting route data to be saved
     * @return saved meeting route data
     */
    @PostMapping("/route/save")
    public ResponseEntity save(MeetingVisitorRoute route) {
        route = this.meetingVisitorRouteService.save(route);
        return ResponseEntity.ok(route);
    }

    /**
     * POST  /route/delete : delete meeting route data
     * @param id meeting id
     * @return HTTP status to figure if operation is successful
     */
    @PostMapping("/route/delete")
    public ResponseEntity deleteRoute(long id) {
        this.meetingVisitorRouteService.deleteByMeetingId(id);
        return ResponseEntity.ok().build();
    }

    /**
     * POST  /route/delete/{id} : delete meeting route data by id
     * @param id route id
     * @return HTTP status to figure if operation is successful
     */
    @PostMapping("/route/delete/{id}")
    public ResponseEntity deleteRouteById(@PathVariable long id) {
        this.meetingVisitorRouteService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
