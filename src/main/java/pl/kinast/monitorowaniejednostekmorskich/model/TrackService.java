package pl.kinast.monitorowaniejednostekmorskich.model;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TrackService {

    public List<Point> getTracks() {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjBCM0I1NEUyRkQ5OUZCQkY5NzVERDMxNDBDREQ4OEI1QzA5RkFDRjMiLCJ0eXAiOiJhdCtqd3QiLCJ4NXQiOiJDenRVNHYyWi03LVhYZE1VRE4ySXRjQ2ZyUE0ifQ.eyJuYmYiOjE2NDMxMDk1OTksImV4cCI6MTY0MzExMzE5OSwiaXNzIjoiaHR0cHM6Ly9pZC5iYXJlbnRzd2F0Y2gubm8iLCJhdWQiOiJhcGkiLCJjbGllbnRfaWQiOiJraW5hc3QucHJvamVrdHlAb3AucGw6a2luYXN0Iiwic2NvcGUiOlsiYXBpIl19.tIT5Khvootzn11s07vfIz00U8AwdtqMLKZLWUqgqKpHuhqaZDKGjDWIaVKUrUVs1iDUiV3erRXcONN_Fcq-x7Z28opW2KcU0jfki6ijoOhIa1XjWDge_AKkDzEBC6vYcYQeCLZvP_n9OX1y3kJx4szKvHxwk6pr4zv4vTDvAU-2AKZSP7Ymd8ne0Qfr2X9-kmrx2OhH_j2Sq9jPb-JnRNfsqG7cDJIIqHv9CSsjDzgCBHqf8JjiqbEKeMXN_Ks_d7SllVWAzP9YhlKiMRlw_TmDGwzRDue96hQFsclX_ZLKHIejUH0IbpEV81NYokTX2Rn35rGf_Ab1moEgEcv-N9DISUOG8LS2AwOktpooEBVRPuFVr-laUVvlIF02bh_Up2Ysrp521F5Lk-bz7n5-_Y-rWdpGtVG7-gb3mlKB4NwOVAdv0HhP-1ylhmD8ex4Ua_s0_GIHyx27qT30cT6qyhthqqIK9fPWD4yAQnABgbmemjPWJ5O4m_SyfaLWrSCH_EO8gDRo6wZFAgGPKEUK79FaQ9JgadM7eRM2oZmi7_5mDzKiM_fwTyamm9GnquaEoHZb4hCEA_talCfqnZmOsLksMGi-_zFM0_2y8xS1ZFmlCZ4evaAQXH1HtR-ETzdGhSbtymhejM4jid0Np6b7FkwVy5UySjiuIUZcplcpZoj0");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<Track[]> exchange = restTemplate.exchange("https://www.barentswatch.no/bwapi/v2/geodata/ais/openpositions?Xmin=7.143163556328481&Xmax=25.973497573450327&Ymin=54.134754461289646&Ymax=60.022531315905454",
                HttpMethod.GET,
                httpEntity,
                Track[].class);




        List<Point> collect = Stream.of(exchange.getBody()).map(track -> new Point(
                                    track.getGeometry().getCoordinates().get(0),
                                    track.getGeometry().getCoordinates().get(1),
                                    track.getName(),
                                    track.getDestination())).collect(Collectors.toList());
        return collect;
    }


}
