import db.DBHelper;
import models.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FixtureTest {

    Fixture fixture;
    FootballTeam homefootballTeam;
    FootballTeam awayfootballTeam;
    Manager manager;
    League league;
    MatchReport matchReport1;


    @Before
    public void before() {
        manager = new Manager("Zsolt Poboda-Salai", "07610335467", "Zsolt@hungarianmail.hu");
        league = new League("North of England Regional Division", LeagueType.NATIONAL, "Lancashire");
        homefootballTeam = new FootballTeam("Bolton Wanderers", manager, league, "nothing", "Bolton");
        awayfootballTeam = new FootballTeam("Dagenham and Redbridge", manager, league, "yes", "Dagenham");
        fixture = new Fixture(1, "Liberty Stadium", league);
        matchReport1 = new MatchReport(fixture, "Wanderers slaughtered in humiliating rout!", "Same", "logo");
    }

    @Test
    public void hasWeek(){
        assertEquals(1, fixture.getWeek());
    }

    @Test
    public void hasVenue(){
        assertEquals("Liberty Stadium", fixture.getVenue());
    }

    @Test
    public void hasLeague(){
        assertEquals(league, fixture.getLeague());
    }

    @Test
    public void canChangeVenue(){
        fixture.setVenue("Ibrox");
        assertEquals("Ibrox", fixture.getVenue());
    }

    @Test
    public void canSetWeek(){
        fixture.setWeek(2);
        assertEquals(2, fixture.getWeek());
    }

    @Test
    public void canConvertHomeGoalsToInteger(){
        fixture.setHomeGoals("3");
        fixture.convertGoalsToInteger(fixture.getHomeGoals());
        assertEquals(3, fixture.getHomeGoals());
    }

    @Test
    public void canConvertAwayGoalsToInteger(){
        fixture.setAwayGoals("3");
        fixture.convertGoalsToInteger(fixture.getAwayGoals());
        assertEquals(3, fixture.getAwayGoals());
    }

    @Test
    public void canSetMatchReport(){
        fixture.setMatchReport(matchReport1);
        assertEquals(matchReport1, fixture.getMatchReport());
    }

    @Test
    public void canSetTeams(){
        fixture.addTeamsToFixture(homefootballTeam, awayfootballTeam);
        assertEquals(awayfootballTeam, fixture.getAwayTeam());
        assertEquals(homefootballTeam, fixture.getHomeTeam());
    }

}
