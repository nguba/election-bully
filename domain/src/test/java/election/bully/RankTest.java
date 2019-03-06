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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:nguba@mac.com">Nico Guba</a>
 */
class RankTest
{
    @Test
    void isNotHigher()
    {
        assertThat(Rank.of(1).isHigherThan(Rank.of(2))).isFalse();
    }

    @Test
    void isHigher()
    {
        assertThat(Rank.of(2).isHigherThan(Rank.of(1))).isTrue();
    }

    @Test
    void isTrueWhenOtherIsNull()
    {
        assertThat(Rank.of(2).isHigherThan(null)).isTrue();
    }
}
