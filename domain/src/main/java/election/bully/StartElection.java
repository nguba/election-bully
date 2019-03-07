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

/**
 * @author <a href="mailto:nguba@mac.com">Nico Guba</a>
 */
public final class StartElection
{
    private final Node node;

    private StartElection(final Node node)
    {
        this.node = node;
    }

    public static StartElection from(final Node node)
    {
        return new StartElection(node);
    }

    public boolean isHigherRank(final Node other)
    {
        return node.isHigherRank(other);
    }
}
