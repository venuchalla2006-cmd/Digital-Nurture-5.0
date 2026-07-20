import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {
    test('should return repository names for techiesyed', async () => {
        const dummyRepos = [
            { name: 'repo1' },
            { name: 'repo2' },
            { name: 'repo3' }
        ];
        
        axios.get.mockResolvedValue({ data: dummyRepos });

        const gitClient = new GitClient();
        const repos = await gitClient.getRepositories('techiesyed');

        expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
        expect(repos).toEqual(['repo1', 'repo2', 'repo3']);
    });
});
