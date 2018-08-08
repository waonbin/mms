package com.zlsoft.manager.web.rest;

import com.zlsoft.common.service.*;
import com.zlsoft.domain.*;
import com.zlsoft.manager.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

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
     * GET  /setting/info : get meeting settings by meeting id
     * @param meetingId meeting id
     * @return The HTTP Status with meeting settings' data
     */
    @GetMapping("/setting/info")
    public ResponseEntity getSettings(long meetingId) {
        Optional<MeetingSetting> optionalMeetingSetting = this.meetingSettingService.findById(meetingId);

        if(optionalMeetingSetting.isPresent()) {
            return ResponseEntity.ok(optionalMeetingSetting.get());
        } else {
            return ResponseEntity.notFound().build();
        }
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
        this.meetingSettingService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * GET  /affair/page/{page} : get meeting affairs by page
     * @param meetingId meeting id
     * @param page zero-based page index
     * @return The HTTP Status with meeting affairs' data
     */
    @GetMapping("/affair/page/{page}")
    public ResponseEntity getAffairs(long meetingId, @PathVariable("page") int page) {
        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<MeetingAffair> meetingAffairs = this.meetingAffairService.findByMeetingId(meetingId, pageRequest);
        return ResponseEntity.ok(meetingAffairs);
    }

    /**
     * GET  /affair/details : get meeting affair's details by meeting affair id
     * @param id meeting affair id
     * @return The HTTP Status with meeting affair's details info
     */
    @GetMapping("/affair/details")
    public ResponseEntity getAffairDetails(long id) {
        Optional<MeetingAffair> optionalMeetingAffair = this.meetingAffairService.findById(id);

        if(optionalMeetingAffair.isPresent()) {
            return ResponseEntity.ok(optionalMeetingAffair.get());
        } else {
            return ResponseEntity.notFound().build();
        }
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
     * GET  /dues/page/{page} : get meeting dues by page
     * @param meetingId meeting id
     * @param page zero-based page index
     * @return The HTTP Status with meeting dues' data
     */
    @GetMapping("/dues/page/{page}")
    public ResponseEntity getDues(long meetingId, @PathVariable("page") int page) {
        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<MeetingDues> meetingDues = this.meetingDuesService.findByMeetingId(meetingId, pageRequest);
        return ResponseEntity.ok(meetingDues);
    }

    /**
     * GET  /dues/details : get meeting dues's details by meeting dues id
     * @param id meeting dues id
     * @return The HTTP Status with meeting dues's details info
     */
    @GetMapping("/dues/details")
    public ResponseEntity getDuesDetails(long id) {
        Optional<MeetingDues> optionalMeetingDues = this.meetingDuesService.findById(id);

        if(optionalMeetingDues.isPresent()) {
            return ResponseEntity.ok(optionalMeetingDues.get());
        } else {
            return ResponseEntity.notFound().build();
        }
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
     * GET  /hotel/page/{page} : get meeting hotel by page
     * @param meetingId meeting id
     * @param page zero-based page index
     * @return The HTTP Status with meeting hotels' data
     */
    @GetMapping("/hotel/page/{page}")
    public ResponseEntity getHotels(long meetingId, @PathVariable("page") int page) {
        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<MeetingHotel> meetingHotels = this.meetingHotelService.findByMeetingId(meetingId, pageRequest);
        return ResponseEntity.ok(meetingHotels);
    }

    /**
     * GET  /hotel/details : get meeting hotels' details by meeting hotel id
     * @param id meeting hotel id
     * @return The HTTP Status with meeting hotels' details info
     */
    @GetMapping("/hotel/details")
    public ResponseEntity getHotelDetails(long id) {
        Optional<MeetingHotel> optionalMeetingHotel = this.meetingHotelService.findById(id);

        if(optionalMeetingHotel.isPresent()) {
            return ResponseEntity.ok(optionalMeetingHotel.get());
        } else {
            return ResponseEntity.notFound().build();
        }
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
     * GET  /place/page/{page} : get meeting place by page
     * @param meetingId meeting id
     * @param page zero-based page index
     * @return The HTTP Status with meeting places' data
     */
    @GetMapping("/place/page/{page}")
    public ResponseEntity getPlaces(long meetingId, @PathVariable("page") int page) {
        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<MeetingHotel> meetingPlaces = this.meetingHotelService.findByMeetingId(meetingId, pageRequest);
        return ResponseEntity.ok(meetingPlaces);
    }

    /**
     * GET  /place/details : get meeting hotels' details by meeting place id
     * @param id meeting place id
     * @return The HTTP Status with meeting places' details info
     */
    @GetMapping("/place/details")
    public ResponseEntity getPlaceDetails(long id) {
        Optional<MeetingPlace> optionalMeetingPlace = this.meetingPlaceService.findById(id);

        if(optionalMeetingPlace.isPresent()) {
            return ResponseEntity.ok(optionalMeetingPlace.get());
        } else {
            return ResponseEntity.notFound().build();
        }
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
     * GET  /route/page/{page} : get meeting route by page
     * @param meetingId meeting id
     * @param page zero-based page index
     * @return The HTTP Status with meeting routes' data
     */
    @GetMapping("/route/page/{page}")
    public ResponseEntity getRoutes(long meetingId, @PathVariable("page") int page) {
        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<MeetingVisitorRoute> meetingVisitorRoutes = this.meetingVisitorRouteService.findByMeetingId(meetingId, pageRequest);
        return ResponseEntity.ok(meetingVisitorRoutes);
    }

    /**
     * GET  /route/details : get meeting routes' details by meeting route id
     * @param id meeting route id
     * @return The HTTP Status with meeting routes' details info
     */
    @GetMapping("/route/details")
    public ResponseEntity getRouteDetails(long id) {
        Optional<MeetingVisitorRoute> optionalMeetingVisitorRoute = this.meetingVisitorRouteService.findById(id);

        if(optionalMeetingVisitorRoute.isPresent()) {
            return ResponseEntity.ok(optionalMeetingVisitorRoute.get());
        } else {
            return ResponseEntity.notFound().build();
        }
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
