package io.github.radixhomework.service;

public interface IService {

    /**
     * Mandatory method for retrieving endpoint context in order to do the HTTP calls.
     *
     * @return The endpoint's context path.
     */
    String getEndpoint();
}
