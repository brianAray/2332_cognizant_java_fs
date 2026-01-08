import { fireEvent, render } from "@testing-library/react"
import Counter from "./Counter"


describe("Counter Component", () => {

    test("Renders initial count and button", () => {
        const {getByText} = render(<Counter/>);

        const countElement = getByText('Count: 0');
        expect(countElement).toBeInTheDocument();

        const incrementButton = getByText("Increment");
        const decrementButton = getByText("Decrement");

        expect(incrementButton).toBeInTheDocument();
        expect(decrementButton).toBeInTheDocument();
    });

    test('Increments and Decrements count when buttons are clicked', () => {
        const {getByText} = render(<Counter/>);

        const countElement = getByText('Count: 0');
        const incrementButton = getByText("Increment");
        const decrementButton = getByText("Decrement");

        // Click the increment button
        fireEvent.click(incrementButton);
        expect(countElement).toHaveTextContent('Count: 1');

        // Click the decrement button
        fireEvent.click(decrementButton);
        expect(countElement).toHaveTextContent('Count: 0');
        
    })

})