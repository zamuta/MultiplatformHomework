//
//  AlbumsViewModel.swift
//  iosApp
//
//  Created by Mikhail Kanshin on 11.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

final class NewsViewModel: ObservableObject {
    private lazy var presenter: NewsPresenter = {
        let presenter = NewsPresenter()
        presenter.handler = { [weak self] code in
            guard let self = self else { return }
            self.news = self.presenter.news as! [NewsInfo]
        }
        return presenter
    }()
    
    public var isLoading: Bool { get { presenter.isLoading } }
    public var page:  Int      { get { Int(presenter.page) } }
    public var total: Int      { get { Int(presenter.total)} }
    
    @Published private(set) var news: [NewsInfo] = []
    
    func fetchNext() {
        presenter.fetchNext()
    }
}
