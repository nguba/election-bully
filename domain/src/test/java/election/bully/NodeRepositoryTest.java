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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;

/**
 * @author <a href="mailto:nguba@mac.com">Nico Guba</a>
 */
class NodeRepositoryTest
{
    static InetAddress address;

    @BeforeAll
    static void init() throws Exception
    {
        address = InetAddress.getLocalHost();
    }

    final Node expected = Node.on(address);

    final NodeRepository repo = new NodeRepository();

    private void create()
    {
        repo.create(expected);
    }

    private void delete()
    {
        repo.delete(address);
    }

    @Test
    void deleteNode() throws Exception
    {
        create();
        hasExpected();

        delete();
        doesNotHaveExpected();
    }

    private void doesNotHaveExpected()
    {
        assertThat(read()).isNull();
    }

    private void hasExpected()
    {
        assertThat(read()).isEqualTo(expected);
    }

    private Node read()
    {
        return repo.read(address);
    }

    @Test
    void saveAndRead()
    {
        create();
        hasExpected();
    }

    @Test
    void readNonExisting()
    {
        assertThat(read()).isNull();
    }
}
