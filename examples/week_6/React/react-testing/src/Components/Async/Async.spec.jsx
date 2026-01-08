import {render, screen} from "@testing-library/react"
import Async from './Async'
import fetchMock from 'jest-fetch-mock';

describe("Async component", () => {
    test('Renders post if request succeeds', async () => {

        // window.fetch = jest.fn();

        // window.fetch.mockResolvedValueOnce({
        //     json: async () => [{id: 1, title: "first post"}]
        // });
        // fetchMock.mockOnce(`[{"id": 1, "title": "first post"}]`);
        fetchMock.mockResponseOnce(JSON.stringify({id: 1, title: "first post"}));

        render(<Async/>);

        // Fetch request will get a list
        // We want all the items in that list

        const itemElement = await screen.findByText("first post");

        expect(itemElement).toBeInTheDocument();
    })
})