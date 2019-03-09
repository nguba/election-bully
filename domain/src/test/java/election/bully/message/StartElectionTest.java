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

package election.bully.message;

import election.bully.ObjectMother;
import election.bully.message.StartElection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:nguba@mac.com">Nico Guba</a>
 */
class StartElectionTest
{
    @Test
    @DisplayName("true when higher rank than accpeting node")
    void isHigherRank()
    {
        assertThat(StartElection.from(ObjectMother.nodeWithRank(2))
                .isHigherRank(ObjectMother.nodeWithRank(1))).isTrue();
    }

    @Test
    @DisplayName("false when lower rank than accpeting node")
    void isLowerRank()
    {
        assertThat(StartElection.from(ObjectMother.nodeWithRank(1))
                .isHigherRank(ObjectMother.nodeWithRank(2))).isFalse();
    }
}
