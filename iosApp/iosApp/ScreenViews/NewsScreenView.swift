//
//  NewsScreenView.swift
//  SwiftUIHomework2
//
//  Created by Mikhail Kanshin on 18.03.2022.
//

import SwiftUI
import shared

struct NewsScreenView: View {
    @StateObject private var viewModel: NewsViewModel = .init()
    
    var body: some View {
        List {
            ForEach(viewModel.news, id: \.uuid) { newsInfo in
                let isLastItem = viewModel.news.last?.uuid == newsInfo.uuid
                NavigationLink(destination: LazyView(NewsInfoScreenView(info: newsInfo))) {
                    NewsCellView(newsInfo:newsInfo)
                        .onAppear {
                            if (isLastItem && !viewModel.isLoading) {
                                viewModel.fetchNext()
                            }
                        }
                }
            }
            if(viewModel.news.count < viewModel.total) {
                ProgressView()
            }
        } // List
        .listStyle(GroupedListStyle())
        .onAppear {
            viewModel.fetchNext()
        }
        .navigationTitle("News")
    }
}

struct NewsScreenView_Previews: PreviewProvider {
    static var previews: some View {
        NewsScreenView()
    }
}
