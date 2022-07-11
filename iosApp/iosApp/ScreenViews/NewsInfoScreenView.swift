//
//  NewsInfo1ScreenView.swift
//  SwiftUIHomework2 (iOS)
//
//  Created by Mikhail Kanshin on 26.03.2022.
//

import SwiftUI
import shared

struct NewsInfoScreenView: View {
    let info: NewsInfo
    
    var body: some View {
        VStack(alignment: .leading) {
            Text(info.title)
                .font(Font.headline.weight(.bold))
                .multilineTextAlignment(.leading)
                .lineLimit(2)
            Spacer().frame(height: 8)
            Text(info.description_)
                .multilineTextAlignment(.leading)
                .lineLimit(4)
            AsyncImage(url: URL(string: info.imageUrl ?? "")) { phase in
                switch phase {
                case .empty:
                    Color.gray.opacity(0.1)
                case .success(let image):
                    image.resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(maxWidth: 360, maxHeight: 360)
                case .failure(_):
                    EmptyView()
                @unknown default:
                    EmptyView()
                }
            } // AsyncImage
            .frame(maxWidth: .infinity)
            Spacer().frame(maxHeight: .infinity)
        } // VStack
        .padding()
        .navigationTitle(info.title)
    }
}

//struct NewsInfo1ScreenView_Previews: PreviewProvider {
//    static var previews: some View {
//        NewsInfoScreenView(info: nil) // TODO: Add example
//    }
//}
