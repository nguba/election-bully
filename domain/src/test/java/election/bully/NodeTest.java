/*
    Copyright (C) 2019  Nicolai P. Guba

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package election.bully;

import nl.jqno.equalsverifier.EqualsVerifier;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:nguba@mac.com">Nico Guba</a>
 */
class NodeTest
{
    Node higher = ObjectMother.nodeWithRank(2);
    Node lower  = ObjectMother.nodeWithRank(1);

    @Test
    void toStringHasMandatoryInfo() throws Exception
    {
        assertThat(higher.toString()).contains("address=", "rank=");
    }

    @Test
    void equalityContract()
    {
        EqualsVerifier.forClass(Node.class).usingGetClass().withOnlyTheseFields("address").verify();
    }

    @Test
    @DisplayName("don't respond to election request from higher rank")
    void doNotRespondToElection()
    {
        assertThat(lower.respond(StartElection.from(higher))).isNull();
    }

    @Test
    @DisplayName("respond to election request from lower rank")
    void respondToElection()
    {
        assertThat(higher.respond(StartElection.from(lower))).isEqualTo(Challenge.from(higher));
    }

    @Test
    @DisplayName("true when higher rank than other node")
    void isHigherRank()
    {
        assertThat(higher.isHigherRank(lower)).isTrue();
    }

    @Test
    @DisplayName("false when lower rank than other node")
    void isLowerRank()
    {
        assertThat(lower.isHigherRank(higher)).isFalse();
    }

    @Test
    @DisplayName("bully others to accept you as coordinator")
    void declareYourselfTheCoordinator()
    {
        assertThat(higher.amCoordinator()).isEqualTo(CoordinatorElected.from(higher));
    }
}
