
import models.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LeagueTest {
    League league;
    Fixture fixture;
    Team team1;
    Team team2;
    LeagueType leagueType;
    Manager manager;

    @Before
    public void setUp(){
        league = new League("Edinburgh Schools", LeagueType.SCHOOLS, "Midlothian");
        fixture = new Fixture(1,"Edinburgh Football Club", league);
        manager = new Manager("David", 077507545, "haggishunters@football.con");
        team1 = new FootballTeam("Edinburgh Haggis Hunters", manager, league, "logo.jpg","Edinburgh");
        team2 = new FootballTeam("Dundee Dodgers", manager, league, "logo.jpg","Dundee");
        }


    @Test
    public void hasName(){
        assertEquals("Edinburgh Schools", league.getName());
    }

    @Test
    public void hasLeagueType(){
        assertEquals(LeagueType.SCHOOLS, league.getLeagueType());
    }

    @Test
    public void hasRegion(){
        assertEquals("Midlothian", league.getRegion());
    }

    @Test
    public void teamListStartEmpty(){
        assertEquals(0, league.teamCount());
    }

    @Test
    public void fixtureListStartsEmpty(){
        assertEquals(0,league.fixtureCount());
    }

    @Test
    public void canAddToTeam(){
        league.addToTeams(team1);
        assertEquals(1, league.teamCount());
    }

    @Test
    public void canRemoveTeam(){
        league.addToTeams(team1);
        league.addToTeams(team2);
        league.removeTeams(team1);
        assertEquals(1,league.teamCount());
    }
}