package com.stackroute.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import com.stackroute.service.TrackServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TrackServiceTest {



    Track track,track1;

    @Mock
    TrackRepository trackRepository;

    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list = null;

    @Before
    public void setUp() {
      MockitoAnnotations.initMocks(this);
      track = new Track();
      track.setId(12);
      track.setName("Mites");
      track.setComment("Good");
      track1=new Track();
      track1.setId(13);
      track1.setName("nice");
      track1.setComment("song");
      list = new ArrayList<>();
      list.add(track);
      list.add(track1);

    }
    @Test
    public void delete() throws TrackNotFoundException {
        track3 = new Track();
        track3.setId(12);
        track3.setName("Mites");
        track3.setComment("Good");
        when(personRepositoryMock.findOne(12)).thenReturn(track3);
        
        List<Track> returned = trackservice.delete(12);
        
        verify(trackrepository, times(1)).findOne(12);
        verify(trackrepository, times(1)).delete(track3);
        verifyNoMoreInteractions(trackrepository);
        
        assertEquals(track3, returned);
    }




    @Test
    public void saveTrackTest() throws TrackAlreadyExistsException
    {
      when(trackRepository.save((Track)any())).thenReturn(track);
      Track savedTrack = trackService.saveTrack(track);
      assertEquals(track,savedTrack);
    }

    @Test
    public void getTrackTest()
    {
      trackRepository.save(track);
      when(trackRepository.findAll()).thenReturn(list);
      List<Track> trackList = trackService.getAllTracks();
      assertEquals(list,trackList);
    }

    @Test
    public void updateTrackTest() throws TrackNotFoundException
    {
      when(trackRepository.save((Track)any())).thenReturn(track);
      Track updateTrack = null;
      try {
        updateTrack = trackService.saveTrack(track);
      } catch (TrackAlreadyExistsException e) {
        e.printStackTrace();
      }
      assertEquals(track,updateTrack);
    }
  }



