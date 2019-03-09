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

import election.bully.message.Challenge;
import election.bully.message.CoordinatorElected;
import election.bully.message.StartElection;

import java.net.InetAddress;

/**
 * @author <a href="mailto:nguba@mac.com">Nico Guba</a>
 */
public final class Node
{
    private final InetAddress address;
    private final Rank        rank;

    private Node(final InetAddress address, final Rank rank)
    {
        this.address = address;
        this.rank = rank;
    }

    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder();
        builder.append("Node [address=").append(address).append(", rank=").append(rank).append("]");
        return builder.toString();
    }

    public static Node with(final InetAddress address, final Rank rank)
    {
        return new Node(address, rank);
    }

    public InetAddress identity()
    {
        return address;
    }

    @Override
    public int hashCode()
    {
        final int prime  = 31;
        int       result = 1;
        result = (prime * result) + ((address == null) ? 0 : address.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Node other = (Node) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        return true;
    }

    public Challenge respond(final StartElection from)
    {
        if (from.isHigherRank(this))
            return null;

        return Challenge.from(this);
    }

    public boolean isHigherRank(final Node other)
    {
        return rank.isHigherThan(other.rank);
    }

    public CoordinatorElected amCoordinator()
    {
        return CoordinatorElected.from(this);
    }
}
