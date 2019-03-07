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

import java.net.InetAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:nguba@mac.com">Nico Guba</a>
 */
public final class NodeRepository
{
    private final Map<InetAddress, Node> nodes = new ConcurrentHashMap<>();

    public void create(final Node node)
    {
        nodes.put(node.identity(), node);
    }

    public Node read(final InetAddress address)
    {
        return nodes.get(address);
    }

    public void delete(final InetAddress address)
    {
        nodes.remove(address);
    }
}
