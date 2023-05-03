/* eslint-disable */
export type Maybe<T> = T | null;
export type InputMaybe<T> = Maybe<T>;
export type Exact<T extends { [key: string]: unknown }> = { [K in keyof T]: T[K] };
export type MakeOptional<T, K extends keyof T> = Omit<T, K> & { [SubKey in K]?: Maybe<T[SubKey]> };
export type MakeMaybe<T, K extends keyof T> = Omit<T, K> & { [SubKey in K]: Maybe<T[SubKey]> };
/** All built-in and custom scalars, mapped to their actual values */
export type Scalars = {
  ID: string;
  String: string;
  Boolean: boolean;
  Int: number;
  Float: number;
};

export type Author = {
  __typename?: 'Author';
  birthDate?: Maybe<Scalars['String']>;
  books: Array<Book>;
  country?: Maybe<Scalars['String']>;
  firstName: Scalars['String'];
  id: Scalars['ID'];
  lastName: Scalars['String'];
};

export type Book = {
  __typename?: 'Book';
  author: Author;
  id: Scalars['ID'];
  isbn?: Maybe<Scalars['String']>;
  publisher?: Maybe<Publisher>;
  title: Scalars['String'];
  year?: Maybe<Scalars['Int']>;
};

export type Mutation = {
  __typename?: 'Mutation';
  createAuthor: Author;
  createBook: Book;
  createPublisher: Publisher;
  deleteAuthor: Scalars['Boolean'];
  deleteBook: Scalars['Boolean'];
  deletePublisher: Scalars['Boolean'];
  updateAuthor: Author;
  updateBook: Book;
  updatePublisher: Publisher;
};


export type MutationCreateAuthorArgs = {
  birthDate?: InputMaybe<Scalars['String']>;
  country?: InputMaybe<Scalars['String']>;
  firstName: Scalars['String'];
  lastName: Scalars['String'];
};


export type MutationCreateBookArgs = {
  authorId: Scalars['ID'];
  isbn?: InputMaybe<Scalars['String']>;
  publisherId?: InputMaybe<Scalars['ID']>;
  title: Scalars['String'];
  year?: InputMaybe<Scalars['Int']>;
};


export type MutationCreatePublisherArgs = {
  location?: InputMaybe<Scalars['String']>;
  name: Scalars['String'];
};


export type MutationDeleteAuthorArgs = {
  id: Scalars['ID'];
};


export type MutationDeleteBookArgs = {
  id: Scalars['ID'];
};


export type MutationDeletePublisherArgs = {
  id: Scalars['ID'];
};


export type MutationUpdateAuthorArgs = {
  birthDate?: InputMaybe<Scalars['String']>;
  country?: InputMaybe<Scalars['String']>;
  firstName?: InputMaybe<Scalars['String']>;
  id: Scalars['ID'];
  lastName?: InputMaybe<Scalars['String']>;
};


export type MutationUpdateBookArgs = {
  id: Scalars['ID'];
  input?: InputMaybe<UpdateBookInput>;
};


export type MutationUpdatePublisherArgs = {
  id: Scalars['ID'];
  location?: InputMaybe<Scalars['String']>;
  name?: InputMaybe<Scalars['String']>;
};

export type Publisher = {
  __typename?: 'Publisher';
  books: Array<Book>;
  id: Scalars['ID'];
  location?: Maybe<Scalars['String']>;
  name: Scalars['String'];
};

export type Query = {
  __typename?: 'Query';
  author?: Maybe<Author>;
  authors: Array<Author>;
  book?: Maybe<Book>;
  books: Array<Book>;
  booksByPublisherId?: Maybe<Array<Maybe<Book>>>;
  publisher?: Maybe<Publisher>;
  publishers: Array<Publisher>;
  woAuthor: Array<Maybe<Book>>;
};


export type QueryAuthorArgs = {
  id: Scalars['ID'];
};


export type QueryBookArgs = {
  id: Scalars['ID'];
};


export type QueryBooksByPublisherIdArgs = {
  id: Scalars['ID'];
};


export type QueryPublisherArgs = {
  id: Scalars['ID'];
};

export type UpdateBookInput = {
  author?: InputMaybe<Scalars['ID']>;
  isbn?: InputMaybe<Scalars['String']>;
  publisher?: InputMaybe<Scalars['ID']>;
  title?: InputMaybe<Scalars['String']>;
  year?: InputMaybe<Scalars['Int']>;
};
