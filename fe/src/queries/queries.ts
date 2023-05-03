import { DocumentNode } from 'graphql';
import { gql } from 'graphql-tag';

export const GET_BOOKS_QUERY: DocumentNode = gql`
        query books {
            books {
                id
                title
                isbn
            }
            
        }
`;


