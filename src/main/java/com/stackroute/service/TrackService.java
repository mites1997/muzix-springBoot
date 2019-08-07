package com.stackroute.service;

import com.stackroute.domain.Track;

import java.util.List;

public interface TrackService {

   public Track saveTrack (Track track) throws TrackAlreadyExistsException;

    public Track getTrackById (int id) throws TrackNotFoundException;

    public List<Track> deleteTrack(int id) throws TrackNotFoundException;


    public List<Track> getAllTracks() throws TrackNotFoundException;

    public Track updateTrack(int id,String comment) throws TrackNotFoundException;


}
